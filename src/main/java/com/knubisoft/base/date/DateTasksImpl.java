package com.knubisoft.base.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String date) {
        LocalDate dateFromString = LocalDate.parse(date);
        return dateFromString.plusDays(1).toString();
    }

    @Override
    public int getMonthFromDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy", Locale.US);
        LocalDate monthFromDate = LocalDate.parse(date, formatter);
        return monthFromDate.getMonthValue();
    }
    //"2015-01-22 10:15:55"
    @Override
    public String findBiggestDate(String date1, String date2, String date3) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime firstDate = LocalDateTime.parse(date1, formatter);
        LocalDateTime secondDate = LocalDateTime.parse(date2, formatter);
        LocalDateTime thirdDate = LocalDateTime.parse(date3, formatter);
        if (firstDate.compareTo(secondDate) > 0 && firstDate.compareTo(thirdDate) > 0) {
            return firstDate.toString().replace("T", " ");
        } else if (secondDate.compareTo(firstDate) > 0 && secondDate.compareTo(thirdDate) > 0) {
            return secondDate.toString().replace("T", " ");
        }else
        return thirdDate.toString().replace("T", " ");
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        LocalDate lastDayOfMonth = LocalDate.parse(date).with(TemporalAdjusters.lastDayOfMonth());;
        return lastDayOfMonth.toString();
    }

    @Override
    public String sumTimes(String time1, String time2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime firstTime = LocalTime.parse(time1, formatter);
        LocalTime secondTime = LocalTime.parse(time2, formatter);
        LocalTime sumTime = firstTime
                .plusHours(secondTime.getHour())
                .plusMinutes(secondTime.getMinute())
                .plusSeconds(secondTime.getSecond());
        return sumTime.format(formatter).toString();
    }

    @Override
    public String getDateAfter2Weeks(String date) {
        LocalDate givenDate = LocalDate.parse(date);
        return givenDate.plusDays(14).toString();
    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {
        LocalDate firstDate = LocalDate.parse(date1);
        LocalDate secondDate = LocalDate.parse(date2);
        long daysBetween = ChronoUnit.DAYS.between(firstDate,secondDate);
        return daysBetween;
    }

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        String[] fridays = new String [2];
        LocalDate givenDate = LocalDate.parse(date);
        fridays[0] = givenDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)).toString();
        fridays[1] = givenDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).toString();
        return fridays;
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        LocalDate monthFromDate = LocalDate.parse(date);
        int remainingMonth = 12 - monthFromDate.getMonthValue();
        return remainingMonth;
    }
}
