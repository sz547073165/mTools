package com.marco.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoField.MICRO_OF_SECOND;
import static java.time.temporal.ChronoField.MILLI_OF_SECOND;

public class DateTimeTool {
    /**
     * UTC为标准时间，原子钟算时间，GMT为格林威治时间，地球公转算时间
     */

    /**
     * 返回unix时间戳，使用Instant类。
     * @return
     */
    public static Long getSecondWithInstant(){
        return Instant.now().getEpochSecond();
    }

    /**
     * 返回unix时间戳（毫秒），使用Instant类。
     * @return
     */
    public static Long getMillisecondWithInstant(){
        return Instant.now().toEpochMilli();
    }

    /**
     * 返回UTC+8:00的ZoneDateTime对象
     * @return
     */
    public static ZonedDateTime getZoneDateTime(){
        return getZoneDateTimeWithZoneId("UTC+8:00");
    }

    /**
     * 返回ZoneDateTime对象，参数出错返回null；
     * @param zoneId 如："UTC+8:00"
     * @return
     */
    public static ZonedDateTime getZoneDateTimeWithZoneId(String zoneId){
        try {
            return ZonedDateTime.now(getZoneId(zoneId));
        } catch (Exception e){
            return null;
        }

    }

    /**
     * 返回ZoneId对象，默认为："UTC+8:00"
     * @return
     */
    public static ZoneId getZoneId(){
        return getZoneId("UTC+8:00");
    }

    /**
     * 返回ZoneId对象，参数出错返回null；
     * @param zoneId 如："UTC+8:00"
     * @return
     */
    public static ZoneId getZoneId(String zoneId){
        try {
            return getZoneId(zoneId);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * 返回ZonedDateTime对象，默认时区："UTC+8:00"
     * @param second 单位：秒
     * @return
     */
    public static ZonedDateTime getZoneDateTimeWithSecond(Long second) {
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(second), getZoneId());
    }

    /**
     * 返回ZonedDateTime对象
     * @param second 单位：秒
     * @param zoneId
     * @return
     */
    public static ZonedDateTime getZoneDateTimeWithSecondAndZoneId(Long second,ZoneId zoneId){
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(second), zoneId);
    }

    /**
     * 返回ZonedDateTime对象，默认时区："UTC+8:00"
     * @param millisecond 单位：毫秒
     * @return
     */
    public static ZonedDateTime getZoneDateTimeWithMillisecond(Long millisecond){
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millisecond),getZoneId());
    }

    /**
     * 返回ZonedDateTime对象
     * @param millisecond 单位：毫秒
     * @param zoneId
     * @return
     */
    public static ZonedDateTime getZoneDateTimeWithMillisecondAndZoneId(Long millisecond,ZoneId zoneId){
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millisecond),zoneId);
    }

    /**
     * 返回unix时间戳
     * @return
     */
    public static Long getSecond(){
        return getZoneDateTime().getLong(MICRO_OF_SECOND);
    }

    /**
     * 返回unix时间戳（毫秒）
     * @return
     */
    public static Long getMillisecond(){
        return getZoneDateTime().getLong(MILLI_OF_SECOND);
    }

    public static String long2String(Long millisecond,String format){
        ZonedDateTime zonedDateTime = getZoneDateTimeWithMillisecond(millisecond);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return zonedDateTime.format(dateTimeFormatter);
    }
}
