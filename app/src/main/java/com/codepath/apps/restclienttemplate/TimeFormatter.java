package com.codepath.apps.restclienttemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class TimeFormatter {

    /**
     * Given a date String of the format given by the Twitter API, returns a display-formatted
     * String of the absolute date of the form "30 Jun 16".
     * This, as of 2016-06-30, matches the behavior of the official Twitter app.
     */
    public static String getTimeStamp(String rawJsonDate) {
        String time = "";
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat format = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        format.setLenient(true);
        try {
            Calendar then = Calendar.getInstance();
            then.setTime(format.parse(rawJsonDate));
            Date date = then.getTime();

            SimpleDateFormat format1 = new SimpleDateFormat("h:mm a \u00b7 dd MMM yy");

            time = format1.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            time = "";
            twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
            format = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
            format.setLenient(true);
            try {
                Calendar then = Calendar.getInstance();
                then.setTime(format.parse(rawJsonDate));
                Date date = then.getTime();

                SimpleDateFormat format1 = new SimpleDateFormat("h:mm a \u00b7 dd MMM yy");

                time = format1.format(date);

            } catch (ParseException f) {
                f.printStackTrace();
            }
            return time;
        }
        return time;
    }
}
