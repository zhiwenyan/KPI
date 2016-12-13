package com.kpi.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.kpi.base.BaseActivity;
import com.kpi.utils.CountDownTimer;
import com.kpi.utils.code;
import com.storm.kpi.R;

/**
 * 找回密码
 */
public class FindPassWordActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_code;
    private Button btn_find_next;


    @Override
    public int getLayoutID() {
        return R.layout.activity_find_code;
    }

    @Override
    public void initView() {
        btn_code = (Button) findViewById(R.id.btn_find_code);
        btn_find_next = (Button) findViewById(R.id.btn_find_next);
    }


    @Override
    public void initListener() {
        btn_code.setOnClickListener(this);
        btn_find_next.setOnClickListener(this);
    }

    @Override
    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.code_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void initData() {
        code.a = 2;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_find_code:
                new TimeCount(60 * 1000, 1000).start();
                break;
            case R.id.btn_find_next:
                Intent intent = new Intent(this, PassWordActivity.class);
                intent.putExtra("title", "忘记密码");
                startActivity(intent);
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
        }
    }

    /***
     * 获取验证码倒计时
     */
    private class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            btn_code.setClickable(false);
            btn_code.setText(millisUntilFinished / 1000 + "秒后可重发");
        }

        @Override
        public void onFinish() {
            btn_code.setText("重新获取");
            btn_code.setClickable(true);
        }
    }
}
