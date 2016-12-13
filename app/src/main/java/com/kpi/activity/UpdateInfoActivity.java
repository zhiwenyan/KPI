package com.kpi.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kpi.base.BaseActivity;
import com.storm.kpi.R;

/**
 * 修改基本信息
 */
public class UpdateInfoActivity extends BaseActivity implements View.OnClickListener {


    @Override
    public int getLayoutID() {
        return R.layout.activity_update_info;
    }

    @Override
    public void initView() {
        EditText ed_update = (EditText) findViewById(R.id.ed_update);
        ed_update.setText(getIntent().getStringExtra("update"));
        ed_update.setHint(getIntent().getStringExtra("updateHint"));
        ed_update.setSelection(getIntent().getStringExtra("update").length());
        TextView tv_save = (TextView) findViewById(R.id.tv_info_save);
        tv_save.setOnClickListener(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.update_ToolBar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {


    }
}
