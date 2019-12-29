package com.example.hmitsuyasu.myapplication.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Log {

    private static DateFormat dateTimeFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SS");

    public static void d(String tag, String msg) {
        String strDate = dateTimeFormat.format(new java.util.Date());
        System.out.println(String.format("%s D/%s %s", strDate, tag, msg));
    }

    public static void e(String tag, String msg) {
        String strDate = dateTimeFormat.format(new java.util.Date());
        System.out.println(String.format("%s E/%s %s", strDate, tag, msg));
    }

    public static void w(String tag, String msg) {
        String strDate = dateTimeFormat.format(new java.util.Date());
        System.out.println(String.format("%s W/%s %s", strDate, tag, msg));
    }
}
