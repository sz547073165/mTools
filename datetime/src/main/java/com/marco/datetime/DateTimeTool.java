package com.marco.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoField.*;

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
     * 返回UTC+8
     * 的ZonedteTime对象
     * @return
     */
    public static ZonedDateTime getZonedDateTime(){
        return getZonedDateTimeWithZoneId("UTC+8");
    }

    /**
     * 返回ZonedDateTime对象，参数出错返回null；
     * @param zoneId 如："UTC+8
     *               "
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithZoneId(String zoneId){
        try {
            return ZonedDateTime.now(getZoneId(zoneId));
        } catch (Exception e){
            return null;
        }
    }

    /**
     * 返回ZoneId对象，默认为："UTC+8
     * "
     * @return
     */
    public static ZoneId getZoneId(){
        return getZoneId("UTC+8");
    }

    /**
     * 返回ZoneId对象，参数出错返回null；
     * @param zoneId 如："UTC+8
     *               "
     * @return
     */
    public static ZoneId getZoneId(String zoneId){
        try {
            return ZoneId.of(zoneId);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * 返回ZonedDateTime对象，默认时区："UTC+8
     * "
     * @param second 单位：秒
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithSecond(Long second) {
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(second), getZoneId());
    }

    /**
     * 返回ZonedDateTime对象
     * @param second 单位：秒
     * @param zoneId
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithSecondAndZoneId(Long second, ZoneId zoneId){
        try {
            return ZonedDateTime.ofInstant(Instant.ofEpochSecond(second), zoneId);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 返回ZonedDateTime对象，默认时区："UTC+8
     * "
     * @param millisecond 单位：毫秒
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithMillisecond(Long millisecond){
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millisecond),getZoneId());
    }

    /**
     * 返回ZonedDateTime对象
     * @param millisecond 单位：毫秒
     * @param zoneId
     * @return
     */
    public static ZonedDateTime getZonedDateTimeWithMillisecondAndZoneId(Long millisecond, ZoneId zoneId){
        try {
            return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millisecond),zoneId);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 返回unix时间戳
     * @return
     */
    public static Long getSecond(){
        return getZonedDateTime().getLong(INSTANT_SECONDS);
    }

    /**
     * 返回unix时间戳（毫秒）
     * @return
     */
    public static Long getMillisecond(){
        ZonedDateTime zonedDateTime = getZonedDateTime();
        Long millisecond = zonedDateTime.getLong(INSTANT_SECONDS)*1000+zonedDateTime.getLong(NANO_OF_SECOND)/1000000;
        return millisecond;
    }

    public static String long2String(Long millisecond,String format){
        ZonedDateTime zonedDateTime = getZonedDateTimeWithMillisecond(millisecond);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return zonedDateTime.format(dateTimeFormatter);
    }
}
