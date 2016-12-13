package com.kpi.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.kpi.base.BaseActivity;
import com.kpi.utils.ToastUtils;
import com.storm.kpi.R;

/**
 * 关于伺动
 */
public class AboutStormActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("关于伺动");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void initView() {
        TextView tv_Storm_info = (TextView) findViewById(R.id.tv_Storm_info);  //伺动简介
        TextView tv_about_Storm = (TextView) findViewById(R.id.tv_about_Storm);  //关于伺动
        TextView tv_storm_advice = (TextView) findViewById(R.id.tv_storm_advice);   //反馈
        TextView tv_storm_gradle = (TextView) findViewById(R.id.tv_storm_gradle);  //新版本
        TextView tv_storm_version = (TextView) findViewById(R.id.tv_storm_version);  //评分
        tv_Storm_info.setOnClickListener(this);
        tv_about_Storm.setOnClickListener(this);
        tv_storm_advice.setOnClickListener(this);
        tv_storm_gradle.setOnClickListener(this);
        tv_storm_version.setOnClickListener(this);

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_about_strom;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
    }

    Intent intent = null;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_Storm_info:
                intent = new Intent(this, StormSummaryActivity.class);  //伺动简介
                startActivity(intent);
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.tv_about_Storm:
                intent = new Intent(this, ContactStormActivity.class);  //联系伺动
                startActivity(intent);
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.tv_storm_advice:         //反馈
                intent = new Intent(this, FeedBackActivity.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.tv_storm_gradle:       //评分
                //打开第三方的Market
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);   //FLAG_ACTIVITY_NEW_TASK
                startActivity(intent);
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.tv_storm_version:     //更新版本
                ToastUtils.showMessage(this, "已是最新版本");
                break;
        }
    }
}
