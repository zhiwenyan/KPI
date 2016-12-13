package com.kpi.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.kpi.base.BaseActivity;
import com.kpi.utils.AppManager;
import com.storm.kpi.R;

/**
 * 用户登录
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        if(EMClient.getInstance().isLoggedInBefore()){
            //登录过直接进入主页面
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }
    }

    @Override
    public void initView() {
        Button btn_login = (Button) findViewById(R.id.btn_user_login);
        TextView tv_user_reg = (TextView) findViewById(R.id.tv_user_reg);
        TextView tv_user_forgetPassword = (TextView) findViewById(R.id.tv_user_forgetPassword);
        tv_user_forgetPassword.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        tv_user_reg.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_user_login:
                //登录
                EMClient.getInstance().login("aaa", "aaa", new EMCallBack() {

                    @Override
                    public void onSuccess() {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }

                    @Override
                    public void onProgress(int progress, String status) {

                    }

                    @Override
                    public void onError(int code, String error) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT ).show();
                            }
                        });
                    }
                });
                /*intent = new Intent(this, MainActivity.class);
                startActivity(intent);*/
                AppManager.getAppManager().finishActivity(this);
                break;
            case R.id.tv_user_reg:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_user_forgetPassword:
                intent = new Intent(this, FindPassWordActivity.class);
                startActivity(intent);
                break;
        }
        this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    //返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            AppManager.getAppManager().finishActivity(this);
            android.os.Process.killProcess(android.os.Process.myPid());
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}