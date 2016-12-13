package com.kpi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kpi.bean.ProductIndex;
import com.storm.kpi.R;

import java.util.ArrayList;


public class ProductListViewAdapter extends BaseAdapter {
    private ArrayList<ProductIndex.DataEntity.DataListTotilEntity> areaBeanArrayList;
    private Context context;

    public ProductListViewAdapter(ArrayList<ProductIndex.DataEntity.DataListTotilEntity> areaBeanArrayList, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.product_item, null);
            viewHolder.productName = (TextView) convertView.findViewById(R.id.tv_product_name);
            viewHolder.productCount = (TextView) convertView.findViewById(R.id.tv_product_count);
            viewHolder.productMom = (TextView) convertView.findViewById(R.id.tv_product_mom);
            viewHolder.productCustomer = (TextView) convertView.findViewById(R.id.tv_product_customer);
            viewHolder.productCustomerMom = (TextView) convertView.findViewById(R.id.tv_product_customerMom);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.productName.setText(areaBeanArrayList.get(position).getProductName());
        viewHolder.productCount.setText(String.valueOf(areaBeanArrayList.get(position).getScanCount()));
        viewHolder.productMom.setText(areaBeanArrayList.get(position).getScanCountMom());
        viewHolder.productCustomer.setText(String.valueOf(areaBeanArrayList.get(position).getScanCustomerCount()));
        viewHolder.productCustomerMom.setText(areaBeanArrayList.get(position).getScanCustomerCountMom());
        return convertView;
    }

    static class ViewHolder {
        TextView productName;  //产品名称
        TextView productCount; //产品件数
        TextView productMom; //环
        TextView productCustomer; //人数
        TextView productCustomerMom;  //环
    }
}
