package com.marco.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class DateTimeTool {
    /**
     * UTC为标准时间，原子钟算时间，GMT为格林威治时间，地球公转算时间
     */

    /**
     * 返回unix时间戳，使用Instant类。
     *
     * @return
     */
    public static Long getSecondWithInstant() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 返回unix时间戳（毫秒），使用Instant类。
     *
     * @return
     */
    public static Long getMillisecondWithInstant() {
        return Instant.now().toEpochMilli();
    }

    /**
     * 返回UTC+8的ZonedteTime对象
     *
     * @return
     */
    public static ZonedDateTime getZonedDateTime() {
        return getZonedDateTimeWithZoneId("UTC+8");
    }

    /**
     * 返回ZonedDateTime对象，参数出错返回null；
     *
     * @param zoneId 如："UTC+8"
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithZoneId(String zoneId) {
        try {
            return ZonedDateTime.now(getZoneId(zoneId));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 返回ZoneId对象，默认为："UTC+8"
     *
     * @return
     */
    public static ZoneId getZoneId() {
        return getZoneId("UTC+8");
    }

    /**
     * 返回ZoneId对象，参数出错返回null；
     *
     * @param zoneId 如："UTC+8"
     * @return
     */
    public static ZoneId getZoneId(String zoneId) {
        try {
            return ZoneId.of(zoneId);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 返回ZonedDateTime对象，默认时区："UTC+8"
     *
     * @param second 单位：秒
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithSecond(Long second) {
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(second), getZoneId());
    }

    /**
     * 返回ZonedDateTime对象，参数有误返回null
     *
     * @param second 单位：秒
     * @param zoneId
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithSecondAndZoneId(Long second, ZoneId zoneId) {
        try {
            return ZonedDateTime.ofInstant(Instant.ofEpochSecond(second), zoneId);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 返回ZonedDateTime对象，参数有误返回null
     *
     * @param second
     * @param zoneId
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithSecondAndZoneId(Long second, String zoneId) {
        try {
            return ZonedDateTime.ofInstant(Instant.ofEpochSecond(second), getZoneId(zoneId));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 返回ZonedDateTime对象，默认时区："UTC+8"
     *
     * @param millisecond 单位：毫秒
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithMillisecond(Long millisecond) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millisecond), getZoneId());
    }

    /**
     * 返回ZonedDateTime对象，参数有误返回null
     *
     * @param millisecond 单位：毫秒
     * @param zoneId
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithMillisecondAndZoneId(Long millisecond, ZoneId zoneId) {
        try {
            return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millisecond), zoneId);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 返回unix时间戳
     *
     * @return
     */
    public static Long getSecond() {
        return getZonedDateTime().getLong(ChronoField.INSTANT_SECONDS);
    }

    /**
     * 返回unix时间戳（毫秒）
     *
     * @return
     */
    public static Long getMillisecond() {
        ZonedDateTime zonedDateTime = getZonedDateTime();
        Long millisecond = zonedDateTime.getLong(ChronoField.INSTANT_SECONDS) * 1000 + zonedDateTime.getLong(ChronoField.NANO_OF_SECOND) / 1000000;
        return millisecond;
    }

    /**
     * 格式化unix时间戳（毫秒），有误返回null
     *
     * @param millisecond 单位：毫秒
     * @param format
     * @return
     */
    public static String millisecond2String(Long millisecond, String format) {
        ZonedDateTime zonedDateTime = getZonedDateTimeWithMillisecond(millisecond);
        DateTimeFormatter dateTimeFormatter = null;
        try {
            dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        } catch (Exception e) {
            return null;
        }
        return zonedDateTime.format(dateTimeFormatter);
    }

    /**
     * 格式化unix时间戳，有误返回null
     *
     * @param second 单位：秒
     * @param format
     * @return
     */
    public static String second2String(Long second, String format) {
        ZonedDateTime zonedDateTime = getZonedDateTimeWithSecond(second);
        DateTimeFormatter dateTimeFormatter = null;
        try {
            dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        } catch (Exception e) {
            return null;
        }
        return zonedDateTime.format(dateTimeFormatter);
    }

    /**
     * 根据格式化过的时间字符串，获取ZonedDateTime对象
     *
     * @param dateTimeStr 如："2017-11-12 12:40:20"
     * @param format      如："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static ZonedDateTime dateTimeStr2ZonedDateTime(String dateTimeStr, String format) {
        DateTimeFormatter dateTimeFormatter = null;
        try {
            dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        } catch (Exception e) {
            return null;
        }
        ZonedDateTime zonedDateTime = null;
        try {
            zonedDateTime = LocalDateTime.parse(dateTimeStr, dateTimeFormatter).atZone(getZoneId());
        } catch (Exception e) {
            return null;
        }
        return zonedDateTime;
    }

    /**
     * 根据格式化过的时间字符串，获取second
     *
     * @param dateTimeStr 如："2017-11-12 12:40:20"
     * @param format      如："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static Long dateTimeStr2second(String dateTimeStr, String format) {
        return dateTimeStr2ZonedDateTime(dateTimeStr, format).getLong(ChronoField.INSTANT_SECONDS);
    }

    /**
     * 根据格式化过的时间字符串，获取millisecond
     *
     * @param dateTimeStr 如："2017-11-12 12:40:20"
     * @param format      如："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static Long dateTimeStr2Millisecond(String dateTimeStr, String format) {
        ZonedDateTime zonedDateTime = dateTimeStr2ZonedDateTime(dateTimeStr, format);
        return zonedDateTime.getLong(ChronoField.INSTANT_SECONDS) * 1000 + zonedDateTime.getLong(ChronoField.NANO_OF_SECOND) / 1000000;
    }

    /**
     * 把millisecond格式化为，如："1天1小时1分钟"
     *
     * @param millisecond
     * @return
     */
    public static String millisecond2String(Long millisecond) {
        long day = millisecond / (24 * 60 * 60 * 1000);
        long hour = (millisecond / (60 * 60 * 1000) - day * 24);
        long min = ((millisecond / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (millisecond / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String result = "";
        if (day > 0) {
            result += day + "天" + hour + "小时" + min + "分钟";
        } else if (day <= 0 && hour > 0) {
            result += hour + "小时" + min + "分钟";
        } else if (day <= 0 && hour <= 0 && min > 0) {
            result += min + "分钟";
        } else if (day <= 0 && hour <= 0 && min <= 0 && s > 0) {
            result += s + "秒";
        } else if (day <= 0 && hour <= 0 && min <= 0 && s <= 0) {
            result += "小于1秒钟";
        }
        return result;
    }

    /**
     * 把second格式化为，如："1天1小时1分钟"
     *
     * @param second
     * @return
     */
    public static String second2String(Long second) {
        return millisecond2String(second * 1000);
    }

    /**
     * 获取两个millisecond之间的间隔，返回如："1天1小时1分钟"
     *
     * @param startMillisecond
     * @param endMillisecond
     * @return
     */
    public static String getMillisecondGap(Long startMillisecond, Long endMillisecond) {
        Long milliGap = endMillisecond - startMillisecond;
        return millisecond2String(milliGap);
    }

    /**
     * 获取两个second之间的间隔，返回如："1天1小时1分钟"
     *
     * @param startSecond
     * @param endSecond
     * @return
     */
    public static String getSecondGap(Long startSecond, Long endSecond) {
        Long secondGap = endSecond - startSecond;
        return second2String(secondGap);
    }
}
