package com.kpi.activity;

import com.kpi.base.BaseActivity;
import com.storm.kpi.R;

/**
 * 备注
 */
public class SignInNotesActivity extends BaseActivity {


    @Override
    public int getLayoutID() {
        return R.layout.activity_sign_in_notes;
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
            getSupportActionBar().setTitle("签到备注");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
}
