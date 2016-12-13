package com.kpi.activity;


import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.kpi.base.BaseActivity;
import com.storm.kpi.R;

/**
 * 账号绑信息
 */
public class BindAccountActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public int getLayoutID() {
        return R.layout.activity_bindaccount;
    }

    @Override
    public void initView() {
        Button btn_account_man = findView(R.id.btn_account_man);
        Button btn_account_remove = findView(R.id.btn_remove_account);
        TextView tv_bindweixn = findView(R.id.tv_bindweixn);
        btn_account_man.setOnClickListener(this);
        btn_account_remove.setOnClickListener(this);
        tv_bindweixn.setOnClickListener(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initToolBar() {
        Toolbar toolbar = findView(R.id.accountinfo_toolbar);
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
            case R.id.btn_account_man:
                startActivity(new Intent(this, AccountManagerActivity.class));
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.tv_bindweixn:
                showPop(v);
                break;
            case R.id.btn_pop_exit:
                popupWindow.dismiss();
                break;
        }
    }


    PopupWindow popupWindow;

    private void showPop(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.account_pop, null);
        Button btn_pop_exit = (Button) view.findViewById(R.id.btn_pop_exit);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
        popupWindow.setAnimationStyle(android.R.style.Widget_Material_Light_PopupWindow);
        popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
        btn_pop_exit.setOnClickListener(this);
    }
}
