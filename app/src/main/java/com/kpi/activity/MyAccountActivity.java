package com.kpi.activity;


import com.kpi.base.BaseActivity;
import com.storm.kpi.R;

public class MyAccountActivity extends BaseActivity {

    @Override
    public int getLayoutID() {
        return R.layout.activity_my_account;
    }

    @Override
    public void initView() {

    }


    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("我的账户");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

}
