package com.kpi.utils;

import android.os.SystemClock;

/**
 * Created by Administrator on 2016/10/19.
 */

public class test {
    public static void main(String[] args) {
        /** ，uptimeMillis()返回的是系统从启动到当前处于非休眠期的时间。
         elapsedRealTime()返回的是系统从启动到现在的时间。
         */
        System.out.println(SystemClock.uptimeMillis());
        System.out.println(SystemClock.elapsedRealtime());
    }
}
