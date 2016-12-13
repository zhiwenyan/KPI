package com.kpi.activity;

import android.widget.ImageView;

import com.kpi.base.BaseActivity;
import com.storm.kpi.R;

/**
 * 联络伺动
 */
public class ContactStormActivity extends BaseActivity {
    private ImageView contacts_storm_img;

    @Override
    public int getLayoutID() {
        return R.layout.activity_contact_storm;
    }

    @Override
    public void initView() {
        contacts_storm_img = findView(R.id.contacts_storm_img);

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
            getSupportActionBar().setTitle("联络伺动");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
