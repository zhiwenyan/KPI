package com.kpi.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.storm.kpi.R;

/**
 * 填写密码
 */
public class PassWordActivity extends BasePassWordActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = (TextView) findViewById(R.id.tv);
        if (getIntent().getStringExtra("title") != null) {
            tv.setText(getIntent().getStringExtra("title"));
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pass_word;
    }
}
