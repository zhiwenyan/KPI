package com.kpi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kpi.utils.ToastUtils;
import com.kpi.utils.code;
import com.storm.kpi.R;

/**
 * 基类PassWordActivity  -->用于注册用户（设置密码）、找回密码、更新密码
 */
public abstract class BasePassWordActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ed_password1;
    private EditText ed_password2;
    private TextInputLayout textInputLayout1;
    private TextInputLayout textInputLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initTooBar();
        initView();
    }

    //获取布局Id
    protected abstract int getLayoutId();

    private void initTooBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.password_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initView() {
        textInputLayout1 = (TextInputLayout) findViewById(R.id.password_TextInputLayout1);
        textInputLayout2 = (TextInputLayout) findViewById(R.id.password_TextInputLayout2);
        ed_password1 = (EditText) findViewById(R.id.ed_reg_password1);
        ed_password2 = (EditText) findViewById(R.id.ed_reg_password2);
        Button btn_reg_finish = (Button) findViewById(R.id.btn_finish);
        btn_reg_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (checkPassword()) {
            if (code.a == 1) {
                ToastUtils.showMessage(this, "注册成功!");
            } else {
                ToastUtils.showMessage(this, "找回密码成功!");
            }
            startActivity(new Intent(this, LoginActivity.class));
            this.finish();
        }
    }

    private boolean checkPassword() {
        if (ed_password1.getText().toString().equals("") || ed_password2.getText().toString().equals("")) {
            ToastUtils.showMessage(this, "请输入密码!");
            return false;
        }
        if (textInputLayout1.getEditText().getText().length() < 8) {
            textInputLayout1.getEditText().setError("密码不能少于8位");
            return false;
        }
        if (textInputLayout1.getEditText().getText().length() > 16) {
            textInputLayout1.getEditText().setError("密码最多16位");
            return false;
        }
        if (!ed_password1.getText().toString().equals(textInputLayout2.getEditText().getText().toString())) {
            textInputLayout2.getEditText().setError("两次密码不一致");
            return false;
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            this.overridePendingTransition(0, R.anim.fade_out);
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
            this.overridePendingTransition(0, R.anim.fade_out);
            return true;
        }
        return false;
    }
}
