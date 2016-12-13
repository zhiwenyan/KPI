package com.kpi.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.kpi.activity.AboutStormActivity;
import com.kpi.activity.BeginHelpActivity;
import com.kpi.activity.BindAccountActivity;
import com.kpi.activity.InfoActivity;
import com.kpi.activity.InforMessActivity;
import com.kpi.activity.SetActivity;
import com.kpi.base.BaseFragment;
import com.kpi.dialog.UserKpiDialog;
import com.storm.kpi.R;

/**
 * 我的智码
 */
public class MyKPIFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public int getLayoutID() {
        return R.layout.fragment_my_kpi;
    }

    @Override
    public void initView() {
        RelativeLayout Layout_info = findView(R.id.Layout_info);
        RelativeLayout Layout_about_Storm = findView(R.id.Layout_about_Storm);
        RelativeLayout Layout_Set = findView(R.id.Layout_Set);
        RelativeLayout beginhelp = findView(R.id.beginhelp);
        RelativeLayout infor_message = findView(R.id.infor_message);
        RelativeLayout infor_bindaccount = findView(R.id.infor_bindaccount);
        RelativeLayout Layout_kpi_Set = findView(R.id.Layout_kpi_Set);
        Layout_info.setOnClickListener(this);
        Layout_about_Storm.setOnClickListener(this);
        Layout_Set.setOnClickListener(this);
        beginhelp.setOnClickListener(this);
        infor_message.setOnClickListener(this);
        infor_bindaccount.setOnClickListener(this);
        Layout_kpi_Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserKpiDialog dialog = new UserKpiDialog();
                dialog.show(getFragmentManager(), "");
            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.Layout_info:
                intent = new Intent(getActivity(), InfoActivity.class);
                break;
            case R.id.Layout_about_Storm:
                intent = new Intent(getActivity(), AboutStormActivity.class);
                break;
            case R.id.beginhelp:
                intent = new Intent(getActivity(), BeginHelpActivity.class);
                break;
            case R.id.Layout_Set:
                intent = new Intent(getActivity(), SetActivity.class);
                break;
            case R.id.infor_message:
                intent = new Intent(getActivity(), InforMessActivity.class);
                break;
            case R.id.infor_bindaccount:
                intent = new Intent(getActivity(), BindAccountActivity.class);
                break;
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

}
