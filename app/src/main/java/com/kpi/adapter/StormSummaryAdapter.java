package com.kpi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kpi.bean.SummaryImg;
import com.storm.kpi.R;

import java.util.ArrayList;


public class StormSummaryAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SummaryImg> summaryImgs;

    public StormSummaryAdapter(Context context, ArrayList<SummaryImg> summaryImgs) {
        this.summaryImgs = summaryImgs;
        this.context = context;
    }


    @Override
    public int getCount() {
        return summaryImgs.size();
    }

    @Override
    public Object getItem(int position) {
        return summaryImgs.get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.summary_list_item, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.summary_img);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(summaryImgs.get(position).getUrl()).crossFade().into(viewHolder.imageView);
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
    }
}
