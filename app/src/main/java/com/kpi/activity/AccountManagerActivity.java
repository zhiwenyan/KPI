package com.kpi.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kpi.base.BaseActivity;
import com.kpi.dialog.AccountInfoFragment;
import com.storm.kpi.R;

/**
 * 账号管理
 */
public class AccountManagerActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_account_man;

    @Override
    public int getLayoutID() {
        return R.layout.activity_account_manager;
    }

    @Override
    public void initView() {
        Button button = findView(R.id.btn_add_account);
        tv_account_man = findView(R.id.tv_account_man);
        button.setOnClickListener(this);
        tv_account_man.setOnClickListener(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initToolBar() {
        Toolbar toolbar = findView(R.id.accountman_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_account:
                startActivity(new Intent(this, AddAccountActivity.class));
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;

            case R.id.tv_account_man:
                AccountInfoFragment accountInfoFragment = new AccountInfoFragment();
                accountInfoFragment.show(getSupportFragmentManager(), "");
                break;
        }

    }
}
