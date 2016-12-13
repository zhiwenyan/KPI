package com.kpi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kpi.bean.InforMess;
import com.storm.kpi.R;

import java.util.ArrayList;


public class InforMessListView extends BaseAdapter {
    private Context context;
    private ArrayList<InforMess> mArrayList = new ArrayList<>();
    public InforMessListView(Context mcontext, ArrayList<InforMess> list){
        this.context = mcontext;
        this.mArrayList = list;
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.informess_list_item, null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.infor_message_title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.infor_message_abstract);
            viewHolder.more = (TextView) convertView.findViewById(R.id.infor_message_more);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(mArrayList.get(position).getTitle());
        viewHolder.content.setText(mArrayList.get(position).getAbst());
        return convertView;
    }
    static class ViewHolder {
        TextView title;
        TextView content;
        TextView more;
    }
}
