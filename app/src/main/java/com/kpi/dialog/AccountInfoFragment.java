package com.kpi.dialog;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.storm.kpi.R;


public class AccountInfoFragment extends DialogFragment implements View.OnClickListener {

    public AccountInfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().setTitle("账户信息");
        View view = inflater.inflate(R.layout.fragment_account_info, container, false);
        Button btn_info_exit = (Button) view.findViewById(R.id.btn_info_exit);
        btn_info_exit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        getDialog().dismiss();
    }
}
