package com.kpi.utils;

import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    //检查月份和日 是否小于10,小于10前面补0
    public static String CheckZero(int year, int month, int day) {
        String str_month = String.valueOf(month);
        String str_day = String.valueOf(day);

        if (month < 10) {
            str_month = new StringBuffer("0") + String.valueOf(month);
        }
        if (day < 10) {
            str_day = new StringBuffer("0") + String.valueOf(day);
        }
        if (month < 10 && day < 10) {
            str_month = new StringBuffer("0") + String.valueOf(month);

            str_day = new StringBuffer("0") + String.valueOf(day);
        }
        return String.valueOf(year) + new StringBuffer("-").append(str_month).append("-").append(str_day);

    }

    static Calendar calendar;

    //当天日期 ————》年-月-日
    public static String CurrentDay() {
        calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = (calendar.get(Calendar.MONTH)) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String currentTime = CheckZero(year, month, day);
        return currentTime;
    }

    //检查日期
    public static boolean checkTime(String startTime, String stopTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //转化为时间
            Date date1 = sdf.parse(startTime);
            Date date2 = sdf.parse(stopTime);
            //获取秒数作比较
            long l1 = date1.getTime() / 1000;
            long l2 = date2.getTime() / 1000;
            if (l2 - l1 >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    //检查结束日期是否日期小于当天的日期
    public static boolean checkStopTime(String stopTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //转化为时间
            Date date2 = sdf.parse(stopTime);
            //获取秒数作比较
            long l1 = new Date().getTime() / 1000;
            long l2 = date2.getTime() / 1000;
            if (l2 - l1 >= 0) {
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    //检查结束日应该晚于开始日
    public static boolean CheckCurrentTime(TextView tv_startTime, TextView tv_stopTime) {
        String startTime = tv_startTime.getText().toString();
        String stopTime = tv_stopTime.getText().toString();
        if (checkTime(startTime, stopTime)) {
            return true;
        } else {
            return false;
        }
    }
}
