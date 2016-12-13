package com.kpi.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.kpi.base.BaseActivity;
import com.kpi.utils.AppManager;
import com.storm.kpi.R;

/**
 * 设置Activity
 */
public class SetActivity extends BaseActivity implements View.OnClickListener {


    //初始化头部的ToolBar
    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("设置");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_set;
    }

    @Override
    public void initView() {
        TextView tv_exit = (TextView) findViewById(R.id.tv_exit);
        TextView tv_update_password = (TextView) findViewById(R.id.tv_update_password);
        tv_exit.setOnClickListener(this);
        tv_update_password.setOnClickListener(this);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_exit:
                showExitDialog();
                break;
            case R.id.tv_update_password:
                startActivity(new Intent(this, NowPassWordActivity.class));
                this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
        }
    }

    //是否退出程序对话框
    private void showExitDialog() {
        new AlertDialog.Builder(this).setTitle("提示").setMessage("确定要退出程序吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        EMClient.getInstance().logout(false, new EMCallBack() {

                            @Override
                            public void onSuccess() {
                                finish();
                                startActivity(new Intent(SetActivity.this, LoginActivity.class));
                                AppManager.getAppManager().finishAllActivity();
                            }

                            @Override
                            public void onProgress(int progress, String status) {

                            }

                            @Override
                            public void onError(int code, String error) {

                            }
                        });

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }
}