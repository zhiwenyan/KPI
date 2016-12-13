package com.kpi.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kpi.activity.SetScanKpiActivity;
import com.storm.kpi.R;


public class UserKpiDialog extends DialogFragment implements View.OnClickListener {
    private TextView tv_scan_kpi;
    private TextView tv_add_delete;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.load_dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_kpi_dialog, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tv_scan_kpi = (TextView) view.findViewById(R.id.tv_set_kpi);
        tv_add_delete = (TextView) view.findViewById(R.id.tv_select_delete_kpi);
        tv_scan_kpi.setOnClickListener(this);
        tv_add_delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_set_kpi:
                startActivity(new Intent(getActivity(), SetScanKpiActivity.class));
                break;
            case R.id.tv_select_delete_kpi:
                break;
        }
        getDialog().dismiss();
    }
}
