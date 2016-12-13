package com.kpi.activity;

import android.os.Bundle;

import com.storm.kpi.R;


/**
 * 找回密码
 */

public class ForgotPassWordActivity extends BasePassWordActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forgot_pass_word;
    }
}
