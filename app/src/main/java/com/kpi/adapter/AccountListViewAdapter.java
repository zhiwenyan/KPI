package com.kpi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kpi.bean.Account;
import com.storm.kpi.R;

import java.util.ArrayList;


public class AccountListViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Account> accounts;

    public AccountListViewAdapter(Context context, ArrayList<Account> accounts) {
        this.accounts = accounts;
        this.context = context;
    }


    @Override
    public int getCount() {
        return accounts.size();
    }

    @Override
    public Object getItem(int position) {
        return accounts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.account_list_item, null);
            viewHolder.accountId = (TextView) convertView.findViewById(R.id.tv_accountId);
            viewHolder.count = (TextView) convertView.findViewById(R.id.tv_account_count);
            viewHolder.detail = (TextView) convertView.findViewById(R.id.tv_account_detail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.accountId.setText(accounts.get(position).getAccountId());
        viewHolder.count.setText(accounts.get(position).getCount());
        viewHolder.detail.setText(accounts.get(position).getDetail());
        return convertView;
    }

    static class ViewHolder {
        TextView accountId;
        TextView count;
        TextView detail;
    }
}
