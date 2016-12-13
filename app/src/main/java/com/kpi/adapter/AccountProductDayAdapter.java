package com.kpi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kpi.bean.AccountScan;
import com.storm.kpi.R;

import java.util.ArrayList;


public class AccountProductDayAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<AccountScan> accounts;

    public AccountProductDayAdapter(Context context, ArrayList<AccountScan> accounts) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.account_product_day_list, null);
            viewHolder.tv_product_name = (TextView) convertView.findViewById(R.id.tv_product_name);
            viewHolder.tv_product_countMom = (TextView) convertView.findViewById(R.id.tv_product_countMom);
            viewHolder.tv_product_count = (TextView) convertView.findViewById(R.id.tv_product_count);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_product_name.setText(accounts.get(position).getName());
        viewHolder.tv_product_countMom.setText(accounts.get(position).getCountMom());
        viewHolder.tv_product_count.setText(accounts.get(position).getCount());
        return convertView;
    }

    static class ViewHolder {
        TextView tv_product_name;
        TextView tv_product_countMom;
        TextView tv_product_count;
    }
}
