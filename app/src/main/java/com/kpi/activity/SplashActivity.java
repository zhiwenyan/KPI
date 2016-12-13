package com.kpi.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.storm.kpi.R;

/**
 * 闪屏页  ---》初始化数据
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        registerReceiver(mHomeKeyEventReceiver, new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                SplashActivity.this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                SplashActivity.this.finish();
            }
        }, 2500);
    }

    //屏蔽返回键
    @Override
    public void onBackPressed() {
    }

    //监听Home键
    private final BroadcastReceiver mHomeKeyEventReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            //Intent.ACTION_CLOSE_SYSTEM_DIALOGS判断是否为home键
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                SplashActivity.this.finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mHomeKeyEventReceiver);
    }
}
