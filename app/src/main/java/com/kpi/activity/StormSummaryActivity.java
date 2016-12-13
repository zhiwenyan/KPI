package com.kpi.activity;

import android.widget.ListView;

import com.kpi.adapter.StormSummaryAdapter;
import com.kpi.base.BaseActivity;
import com.kpi.bean.SummaryImg;
import com.storm.kpi.R;

import java.util.ArrayList;

//伺动简介
public class StormSummaryActivity extends BaseActivity {
    private String[] ul = {
            "http://192.168.0.19:4444/image/storminfo/p1.PNG",
            "http://192.168.0.19:4444/image/storminfo/p2.PNG",
            "http://192.168.0.19:4444/image/storminfo/p3.PNG",
            "http://192.168.0.19:4444/image/storminfo/p4.PNG",
            "http://192.168.0.19:4444/image/storminfo/p5.PNG",
            "http://192.168.0.19:4444/image/storminfo/p6.PNG",
            "http://192.168.0.19:4444/image/storminfo/p7.PNG",
            "http://192.168.0.19:4444/image/storminfo/p8.PNG",
            "http://192.168.0.19:4444/image/storminfo/p9.PNG",
            "http://192.168.0.19:4444/image/storminfo/p10.PNG",
            "http://192.168.0.19:4444/image/storminfo/p11.PNG",
            "http://192.168.0.19:4444/image/storminfo/p12.PNG",
            "http://192.168.0.19:4444/image/storminfo/p13.PNG",
            "http://192.168.0.19:4444/image/storminfo/p14.PNG",
            "http://192.168.0.19:4444/image/storminfo/p15.PNG",
            "http://192.168.0.19:4444/image/storminfo/p16.PNG",
            "http://192.168.0.19:4444/image/storminfo/p17.PNG",
            "http://192.168.0.19:4444/image/storminfo/p18.PNG"};

    private ListView listView;
    private ArrayList<SummaryImg> summaryImgs;


    @Override
    public int getLayoutID() {
        return R.layout.activity_storm_about;
    }

    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("伺动简介");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void initView() {
        listView = findView(R.id.storm_image_list);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        summaryImgs = new ArrayList<>();
        SummaryImg summaryImg;
        for (int i = 0, count = ul.length; i < count; i++) {
            summaryImg = new SummaryImg();
            summaryImg.setUrl(ul[i]);
            summaryImgs.add(summaryImg);
        }
        listView.setAdapter(new StormSummaryAdapter(this, summaryImgs));
    }

}
