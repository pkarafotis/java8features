package com.company.demo.java8features.dateapi;

import java.sql.Date;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateApi {

    public static void clock() {
        Clock clock = Clock.systemDefaultZone();

        System.out.println("Getting legacy date from instant: " + Date.from(clock.instant()));
    }

    public static void localDate() {

        // a date in ISO format (yyyy-MM-dd) without time
        LocalDate now = LocalDate.now();

        System.out.println("LocalDate is: " + now);

        LocalDate tomorrow = now.plusDays(1);

        System.out.println("Tomorrow will be: " + tomorrow);

        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int dayOfMonth = now.getDayOfMonth();

        boolean leapYear = now.isLeapYear();

        System.out.println("Day of week: " + dayOfWeek + " and day of month: " + dayOfMonth + ". Is leap year? " + leapYear);
    }

    public static void localTime() {

        // represents time without a date.
        LocalTime now = LocalTime.now();
        sleep();
        LocalTime later = LocalTime.now();

        System.out.println("Time is " + now);
        System.out.println("now is before later? " + now.isBefore(later));
    }

    public static void dateTimeFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm:ss");
        System.out.println("Local formatted datetime is: " + formatter.format(LocalDateTime.now()));
    }

    public static void zonedDateTime() {
        System.out.println("All system Zone IDs: " + ZoneId.getAvailableZoneIds());

        ZoneId nyZoneId = ZoneId.of("America/New_York");
        ZoneId grZoneId = ZoneId.of("Europe/Athens");

        LocalDateTime today = LocalDateTime.now();

        // Zoned date gr
        ZonedDateTime grDateTime = today.atZone(grZoneId);

        // Zoned date at ny
        ZonedDateTime nyDateTime = grDateTime.withZoneSameInstant(nyZoneId);

        System.out.println("GR datetime: " + grDateTime);
        System.out.println("NY datetime: " + nyDateTime);
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
