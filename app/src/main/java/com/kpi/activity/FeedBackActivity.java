package com.kpi.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kpi.base.BaseActivity;
import com.kpi.utils.ToastUtils;
import com.storm.kpi.R;


/**
 * 反馈
 */
public class FeedBackActivity extends BaseActivity implements View.OnClickListener {
    private EditText editText;

    @Override
    public void initView() {
        editText = (EditText) findViewById(R.id.ed_feedback);
        Button button = (Button) findViewById(R.id.btn_feedback);
        button.setOnClickListener(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_feed_back;
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
            getSupportActionBar().setTitle("反馈");
        }
    }

    @Override
    public void onClick(View v) {
        if (editText.getText().toString().length() == 0) {
            ToastUtils.showMessage(this, "请输入你的反馈意见!");
        }
    }
}
