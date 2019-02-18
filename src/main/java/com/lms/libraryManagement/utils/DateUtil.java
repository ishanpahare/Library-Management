package com.lms.libraryManagement.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {

    public static String addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime().toString();
    }

    public static long differenceInDays(Date startDate, Date endDate) {
        long duration = endDate.getTime() - startDate.getTime();
        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
        return diffInDays;
    }
}
