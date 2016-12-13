package com.kpi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kpi.bean.AreaBean;
import com.storm.kpi.R;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter {
    private ArrayList<AreaBean> areaBeanArrayList;
    private Context context;

    public ListViewAdapter(ArrayList<AreaBean> areaBeanArrayList, Context context) {
        this.areaBeanArrayList = areaBeanArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return areaBeanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return areaBeanArrayList.get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
            viewHolder.area = (TextView) convertView.findViewById(R.id.tv_area_name);
            viewHolder.scanCount = (TextView) convertView.findViewById(R.id.tv_area_scancount);
            viewHolder.scanCountMom = (TextView) convertView.findViewById(R.id.tv_area_mom);
            viewHolder.scanCustomerCount = (TextView) convertView.findViewById(R.id.tv_area_customer);
            viewHolder.scanCustomerCountMom = (TextView) convertView.findViewById(R.id.tv_area_percent);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.area.setText(areaBeanArrayList.get(position).getArea());
        viewHolder.scanCount.setText(areaBeanArrayList.get(position).getScanCount());
        viewHolder.scanCountMom.setText(areaBeanArrayList.get(position).getScanCountMom());
        viewHolder.scanCustomerCount.setText(areaBeanArrayList.get(position).getScanCustomerCount());
        viewHolder.scanCustomerCountMom.setText(areaBeanArrayList.get(position).getScanCustomerCountMom());
        return convertView;
    }

    static class ViewHolder {
        TextView area;  //地区
        TextView scanCount; //件数
        TextView scanCountMom; //环
        TextView scanCustomerCount; //人数
        TextView scanCustomerCountMom;  //环比
    }
}
