package com.marco.datetime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
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
        ZoneId zoneId1 = DateTimeTool.getZoneId("UTC+8" +
                "");
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
        ZonedDateTime zonedDateTime2 = DateTimeTool.getZonedDateTimeWithMillisecondAndZoneId(-Instant.now().toEpochMilli(),DateTimeTool.getZoneId("agag"));
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

}