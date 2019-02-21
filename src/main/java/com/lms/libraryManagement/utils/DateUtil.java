package com.lms.libraryManagement.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtil {

    public static String addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime().toString();
    }

    public static long differenceInDays(String startDate, Date endDate) {
        SimpleDateFormat format = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        Date first = null;
        try {
            first = format.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long duration = endDate.getTime() - first.getTime();
        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
        return diffInDays;
    }
}
