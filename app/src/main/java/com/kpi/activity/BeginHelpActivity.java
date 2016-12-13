package com.kpi.activity;


import android.support.v7.widget.Toolbar;

import com.kpi.base.BaseActivity;
import com.storm.kpi.R;

/**
 * 新手帮助
 */
public class BeginHelpActivity extends BaseActivity {

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_beginhelp;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.help_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

}
