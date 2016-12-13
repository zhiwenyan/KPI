package com.kpi.activity;

import com.kpi.base.BaseActivity;
import com.storm.kpi.R;

/**
 * 商机
 */
public class BusinessOpportunityActivity extends BaseActivity {

    @Override
    public int getLayoutID() {
        return R.layout.activity_business_opportunity;
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
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("商机");
        }
    }
}
