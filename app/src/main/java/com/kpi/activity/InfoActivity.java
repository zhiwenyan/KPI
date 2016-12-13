package com.kpi.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kpi.base.BaseActivity;
import com.kpi.dialog.ImgDialogFragment;
import com.storm.kpi.R;

/**
 * 用户详细信息
 */
public class InfoActivity extends BaseActivity implements View.OnClickListener {
    private TextView username;
    private TextView company;
    private TextView job;
    private TextView note;
    private TextView sex;

    @Override
    public int getLayoutID() {
        return R.layout.activity_info;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.info_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void initView() {
        RelativeLayout update_logo = (RelativeLayout) findViewById(R.id.update_logo);   ///更新头像
        RelativeLayout update_username = (RelativeLayout) findViewById(R.id.update_username);  //更新姓名
        RelativeLayout update_sex = (RelativeLayout) findViewById(R.id.update_sex); //更新性别
        RelativeLayout update_company = (RelativeLayout) findViewById(R.id.update_company);  //更新公司
        RelativeLayout update_job = (RelativeLayout) findViewById(R.id.update_job);   //更新职位
        RelativeLayout update_note = (RelativeLayout) findViewById(R.id.update_note);   //更新备注

        username = (TextView) findViewById(R.id.tv_update_username);
        company = (TextView) findViewById(R.id.tv_update_company);
        job = (TextView) findViewById(R.id.tv_update_job);
        note = (TextView) findViewById(R.id.tv_update_note);
        sex = (TextView) findViewById(R.id.tv_update_sex);

        update_logo.setOnClickListener(this);
        update_username.setOnClickListener(this);
        update_sex.setOnClickListener(this);
        update_company.setOnClickListener(this);
        update_job.setOnClickListener(this);
        update_note.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.update_logo:
                ImgDialogFragment dialogFragment = new ImgDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "dialog");
                break;
            case R.id.update_username:
                startUpdateActivity(username.getText().toString(), "修改姓名");
                break;
            case R.id.update_sex:
                showSexDialog();
                break;
            case R.id.update_company:
                startUpdateActivity(company.getText().toString(), "修改公司");
                break;
            case R.id.update_job:
                startUpdateActivity(job.getText().toString(), "修改职位");
                break;
            case R.id.update_note:
                startUpdateActivity(note.getText().toString(), "修改备注");
                break;
            default:
                break;
        }
    }

    Intent intent;

    private void startUpdateActivity(String updateMessage, String UpdateHintMessage) {
        intent = new Intent(this, UpdateInfoActivity.class);
        intent.putExtra("update", updateMessage);
        intent.putExtra("updateHint", UpdateHintMessage);
        startActivityForResult(intent, 0x1);
        this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    //性别单选对话框
    private void showSexDialog() {
        final String[] items = {"男", "女"};
        new AlertDialog.Builder(this).setTitle("").setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    sex.setText(items[0]);
                } else if (which == 1) {
                    sex.setText(items[1]);
                }
                dialog.dismiss();
            }
        }).create().show();
    }


    //处理Activity返回结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
