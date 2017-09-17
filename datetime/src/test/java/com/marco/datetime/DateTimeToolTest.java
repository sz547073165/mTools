package com.marco.datetime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeToolTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSecondWithInstant() throws Exception {
        Long time = DateTimeTool.getSecondWithInstant();
        System.out.println(time);
    }

    @Test
    public void getMillisecondWithInstant() throws Exception {
        Long time = DateTimeTool.getMillisecondWithInstant();
        System.out.println(time);
    }

    @Test
    public void getZonedDateTime() throws Exception {
        ZonedDateTime zonedDateTime = DateTimeTool.getZonedDateTime();
        System.out.println(zonedDateTime);
    }

    @Test
    public void getZonedDateTimeWithZoneId() throws Exception {
        ZonedDateTime zonedDateTime1 = DateTimeTool.getZonedDateTimeWithZoneId("UTC+8");
        System.out.println(zonedDateTime1);
        ZonedDateTime zonedDateTime2 = DateTimeTool.getZonedDateTimeWithZoneId("1asg");
        System.out.println(zonedDateTime2);
    }

    @Test
    public void getZoneId() throws Exception {
        ZoneId zoneId = DateTimeTool.getZoneId();
        System.out.println(zoneId);
    }

    @Test
    public void getZoneId1() throws Exception {
        ZoneId zoneId1 = DateTimeTool.getZoneId("UTC+8");
        System.out.println(zoneId1);
        ZoneId zoneId2 = DateTimeTool.getZoneId("asdga ");
        System.out.println(zoneId2);
    }

    @Test
    public void getZonedDateTimeWithSecond() throws Exception {
        ZonedDateTime zonedDateTime = DateTimeTool.getZonedDateTimeWithSecond(Instant.now().getEpochSecond());
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime2 = DateTimeTool.getZonedDateTimeWithSecond(-Instant.now().getEpochSecond());
        System.out.println(zonedDateTime2);
    }

    @Test
    public void getZonedDateTimeWithSecondAndZoneId() throws Exception {
        ZonedDateTime zonedDateTime = DateTimeTool.getZonedDateTimeWithSecondAndZoneId(Instant.now().getEpochSecond(), ZoneId.of("UTC+8"));
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime2 = DateTimeTool.getZonedDateTimeWithSecondAndZoneId(Instant.now().getEpochSecond(), DateTimeTool.getZoneId("agag"));
        System.out.println(zonedDateTime2);
    }

    @Test
    public void getZonedDateTimeWithMillisecond() throws Exception {
        ZonedDateTime zonedDateTime1 = DateTimeTool.getZonedDateTimeWithMillisecond(Instant.now().toEpochMilli());
        System.out.println(zonedDateTime1);
        ZonedDateTime zonedDateTime2 = DateTimeTool.getZonedDateTimeWithMillisecond(-Instant.now().toEpochMilli());
        System.out.println(zonedDateTime2);
    }

    @Test
    public void getZonedDateTimeWithMillisecondAndZoneId() throws Exception {
        ZonedDateTime zonedDateTime1 = DateTimeTool.getZonedDateTimeWithMillisecondAndZoneId(Instant.now().toEpochMilli(), ZoneId.of("UTC+8"));
        System.out.println(zonedDateTime1);
        ZonedDateTime zonedDateTime2 = DateTimeTool.getZonedDateTimeWithMillisecondAndZoneId(-Instant.now().toEpochMilli(), DateTimeTool.getZoneId("agag"));
        System.out.println(zonedDateTime2);
    }

    @Test
    public void getSecond() throws Exception {
        Long time = DateTimeTool.getSecond();
        System.out.println(time);
    }

    @Test
    public void getMillisecond() throws Exception {
        Long time = DateTimeTool.getMillisecond();
        System.out.println(time);
    }

    @Test
    public void millisecond2String() throws Exception {
        Long time = DateTimeTool.getMillisecondWithInstant();
        String str = "yyyy-MM-dd HH:mm:ss";
        System.out.println(DateTimeTool.millisecond2String(time, str));
        Long time2 = DateTimeTool.getSecondWithInstant();
        String str2 = "yyyy-MM-dd HH:mm:ss";
        System.out.println(DateTimeTool.second2String(time2, str2));
    }

    @Test
    public void dateStr2second() throws Exception {
        String dateTimeStr = "2017-11-12 12:40:20";
        String format = "yyyy-MM-dd HH:mm:ss";
        Long second = DateTimeTool.dateTimeStr2second(dateTimeStr, format);
        System.out.println(second);
        Long millisecond = DateTimeTool.dateTimeStr2Millisecond(dateTimeStr, format);
        System.out.println(millisecond);
    }

    @Test
    public void timeGap() {
        Long startMillisecond = DateTimeTool.getMillisecondWithInstant();
        Long endMillisecond = startMillisecond + 146234234L;
        String gap = DateTimeTool.getMillisecondGap(startMillisecond, endMillisecond);
        System.out.println(gap);
        String gap2 = DateTimeTool.getSecondGap(startMillisecond / 1000, endMillisecond / 1000);
        System.out.println(gap2);
    }

}