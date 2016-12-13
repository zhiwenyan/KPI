package com.kpi.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import com.kpi.base.BaseActivity;
import com.storm.kpi.R;

public class AddAccountActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_account;

    @Override
    public int getLayoutID() {
        return R.layout.activity_add_account;
    }

    @Override
    public void initToolBar() {
        Toolbar toolbar = findView(R.id.add_account_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void initView() {
        rg_account = findView(R.id.rg_account);
    }

    @Override
    public void initListener() {
        rg_account.setOnCheckedChangeListener(this);
    }

    @Override
    public void initData() {

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb1_add_account:   //区域
                showPerSingleDialog(new String[]{"华东", "华北", "河北", "广东"});
                break;
            case R.id.rb2_add_account:  //产品
                showProductSingleDialog(new String[]{"流通群", "综饮", "茶", "果汁"});
                break;
        }
    }

    //区域单选框
    int perSelectItem = 0;

    private void showPerSingleDialog(String[] text) {
        new AlertDialog.Builder(this).setSingleChoiceItems(text, perSelectItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                perSelectItem = which;
                dialog.dismiss();
            }
        }).setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }

    //产品单选框
    int productSelectItem = 0;

    private void showProductSingleDialog(String[] text) {
        new AlertDialog.Builder(this).setSingleChoiceItems(text, productSelectItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                productSelectItem = which;
                dialog.dismiss();
            }
        }).setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }
}
