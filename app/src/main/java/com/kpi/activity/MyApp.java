package com.kpi.activity;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.hyphenate.easeui.controller.EaseUI;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EaseUI.getInstance().init(this, null);
        SDKInitializer.initialize(getApplicationContext());
    }
}
