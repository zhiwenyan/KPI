package com.kpi.activity;

import android.app.DatePickerDialog;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kpi.adapter.ListViewAdapter;
import com.kpi.base.BaseActivity;
import com.kpi.bean.AreaBean;
import com.kpi.bean.AreaPerformance;
import com.kpi.utils.DateUtil;
import com.kpi.utils.DialogUtils;
import com.kpi.utils.JsonRequest;
import com.kpi.utils.NetUtils;
import com.kpi.utils.ToastUtils;
import com.kpi.utils.UrlUtils;
import com.storm.kpi.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 区域表现
 */
public class AreaPerformanceActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private ListView mListView;
    private RequestQueue queue;
    private AreaPerformance areaPerformance;
    private LinearLayout layout1;
    private LinearLayout layout2;
    private ListView listView_top;
    private ListView listView_bottom;
    private LinearLayout hideOrshowDate;       //动态显示自选的时间

    private TextView tv_area_startTime;
    private TextView tv_area_stopTime;
    private TextView tv_area_startTimeMom;
    private TextView tv_area_stopTimeMom;
    private RadioButton rb_area_top;
    private RadioButton rb_area_per;


    @Override
    public int getLayoutID() {
        return R.layout.activity_area_performance;
    }

    @Override
    public void initData() {
        queue = Volley.newRequestQueue(this);
        UrlUtils.btn = "1";
        showProgressDialog();
        if (NetUtils.isNetworkConnected(this)) {
            RequestAreaValue();
        }
    }
    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("区域表现");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public void initView() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg_AreaPerformance);
        RadioGroup rg_area = (RadioGroup) findViewById(R.id.rg_area);
        mListView = (ListView) findViewById(R.id.mListView);
        layout1 = (LinearLayout) findViewById(R.id.layout_listView1);
        layout2 = (LinearLayout) findViewById(R.id.layout_listView2);
        listView_top = (ListView) findViewById(R.id.mListView_top_five);
        listView_bottom = (ListView) findViewById(R.id.mListView_bottom_five);
        hideOrshowDate = (LinearLayout) findViewById(R.id.show_hide_layout);
        tv_area_startTime = (TextView) findViewById(R.id.tv_area_startTime);
        tv_area_stopTime = (TextView) findViewById(R.id.tv_area_stopTime);
        tv_area_startTimeMom = (TextView) findViewById(R.id.tv_area_startTimeMom);
        tv_area_stopTimeMom = (TextView) findViewById(R.id.tv_area_stopTimeMom);
        rb_area_top = (RadioButton) findViewById(R.id.rb_area_top);
        rb_area_per = (RadioButton) findViewById(R.id.rb_area_per);

        Spinner sp_area_type = (Spinner) findViewById(R.id.sp_area_type);
        Spinner sp_area_sort = (Spinner) findViewById(R.id.sp_area_sort);
        RadioButton rb_select = (RadioButton) findViewById(R.id.rb_area_select);

        rb_select.setOnCheckedChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        rg_area.setOnCheckedChangeListener(this);

        tv_area_startTime.setOnClickListener(this);
        tv_area_stopTime.setOnClickListener(this);
        tv_area_startTimeMom.setOnClickListener(this);
        tv_area_stopTimeMom.setOnClickListener(this);

        tv_area_startTime.setText(DateUtil.CurrentDay());
        tv_area_stopTime.setText(DateUtil.CurrentDay());
        tv_area_startTimeMom.setText(DateUtil.CurrentDay());
        tv_area_stopTimeMom.setText(DateUtil.CurrentDay());
        if (sp_area_sort != null) {
            sp_area_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            UrlUtils.order = "SCAN_COUNT";
                            break;
                        case 1:
                            UrlUtils.order = "SCAN_COUNT_MOM";
                            break;
                        case 2:
                            UrlUtils.order = "CUSTOMER_COUNT";
                            break;
                        case 3:
                            UrlUtils.order = "CUSTOMER_COUNT_MOM";
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        if (sp_area_type != null) {
            sp_area_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    UrlUtils.type = String.valueOf(position + 1);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
    }



    @Override
    public void initListener() {

    }



    private void showProgressDialog() {
        DialogUtils.showProgressDialog(this, "数据加载中...");
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_area_today:
                UrlUtils.btn = "1";
                RequestAreaValue();
                break;
            case R.id.rb_area_week:
                UrlUtils.btn = "2";
                RequestAreaValue();
                break;
            case R.id.rb_area_mouth:
                UrlUtils.btn = "3";
                RequestAreaValue();
                break;
            case R.id.rb_area_select:
                UrlUtils.btn = "4";
                //   RequestAreaValue();
                break;
            case R.id.rb_area_top:
                layout2.setVisibility(View.VISIBLE);
                layout1.setVisibility(View.GONE);
                RequestAreaValue();
                break;
            case R.id.rb_area_per:
                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
                break;

        }
    }

    private void RequestAreaValue() {
        JsonRequest jsonRequest = new JsonRequest(new UrlUtils().AreaPer_Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                areaPerformance = new Gson().fromJson(jsonObject.toString(), AreaPerformance.class);
                if (areaPerformance.isSuccess()) {
                    DialogUtils.dissmissProgressDialog();
                    if (rb_area_per.isChecked()) {
                        updateAreaValue();
                    } else if (rb_area_top.isChecked()) {
                        updateAreaTopValue();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ToastUtils.show(AreaPerformanceActivity.this);
            }
        });
        queue.add(jsonRequest);
    }

    private void updateAreaValue() {
        AreaBean areaBean;
        ArrayList<AreaBean> areaBeens1 = new ArrayList<>();
        AreaPerformance.DataEntity dataEntity = areaPerformance.getData();
        List<AreaPerformance.DataEntity.DataListAllEntity> allEntities = dataEntity.getDataListAll();
        for (int i = 0, count = allEntities.size(); i < count; i++) {
            areaBean = new AreaBean();
            areaBean.setArea(allEntities.get(i).getArea());
            areaBean.setScanCount(allEntities.get(i).getScanCount() + "");
            areaBean.setScanCountMom(allEntities.get(i).getScanCountMom());
            areaBean.setScanCustomerCount(allEntities.get(i).getScanCustomerCount() + "");
            areaBean.setScanCustomerCountMom(allEntities.get(i).getScanCustomerCountMom());
            areaBeens1.add(areaBean);
        }
        ListViewAdapter gridViewAdapter = new ListViewAdapter(areaBeens1, this);
        mListView.setAdapter(gridViewAdapter);
    }


    private void updateAreaTopValue() {
        /**
         * 前5名
         */
        AreaBean areaBean;
        ArrayList<AreaBean> areaBeens_top = new ArrayList<>();
        AreaPerformance.DataEntity dataEntity = areaPerformance.getData();
        List<AreaPerformance.DataEntity.DataListAllEntity> allEntities = dataEntity.getDataListAll();
        if (allEntities.size() > 0) {
            for (int i = 0; i < 5; i++) {
                areaBean = new AreaBean();
                areaBean.setArea(allEntities.get(i).getArea());
                areaBean.setScanCount(allEntities.get(i).getScanCount() + "");
                areaBean.setScanCountMom(allEntities.get(i).getScanCountMom());
                areaBean.setScanCustomerCount(allEntities.get(i).getScanCustomerCount() + "");
                areaBean.setScanCustomerCountMom(allEntities.get(i).getScanCustomerCountMom());
                areaBeens_top.add(areaBean);
            }
            ListViewAdapter item_top = new ListViewAdapter(areaBeens_top, this);
            listView_bottom.setAdapter(item_top);
        }


        /**
         * 后5名
         */
        ArrayList<AreaBean> areaBeens_bottom = new ArrayList<>();
        if (allEntities.size() > 0) {
            for (int i = allEntities.size() - 5, count = allEntities.size(); i < count; i++) {
                areaBean = new AreaBean();
                areaBean.setArea(allEntities.get(i).getArea());
                areaBean.setScanCount(allEntities.get(i).getScanCount() + "");
                areaBean.setScanCountMom(allEntities.get(i).getScanCountMom());
                areaBean.setScanCustomerCount(allEntities.get(i).getScanCustomerCount() + "");
                areaBean.setScanCustomerCountMom(allEntities.get(i).getScanCustomerCountMom());
                areaBeens_bottom.add(areaBean);
            }
            ListViewAdapter item_bottom = new ListViewAdapter(areaBeens_bottom, this);
            listView_top.setAdapter(item_bottom);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            showDateLayout();
        } else {
            hideDateLayout();
        }
    }

    //移除时间的布局
    private void hideDateLayout() {
        hideOrshowDate.setVisibility(View.GONE);
    }

    //显示时间的布局
    private void showDateLayout() {
        hideOrshowDate.setVisibility(View.VISIBLE);
        //透明度动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(800);
        hideOrshowDate.setAnimation(alphaAnimation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_area_startTime:
                showDateDialog(v);
                break;
            case R.id.tv_area_stopTime:
                showDateDialog(v);
                break;
            case R.id.tv_area_startTimeMom:
                showDateDialog(v);
                break;
            case R.id.tv_area_stopTimeMom:
                showDateDialog(v);
                break;
        }
    }

    //日期选择框
    private void showDateDialog(final View v) {
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                CheckMonthAndDay(year, monthOfYear + 1, dayOfMonth, v);
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }


    private void CheckMonthAndDay(int year, int month, int day, View v) {
        switch (v.getId()) {
            case R.id.tv_area_startTime:
                tv_area_startTime.setText(DateUtil.CheckZero(year, month, day));
                UrlUtils.DDatefrom = DateUtil.CheckZero(year, month, day);
                break;
            case R.id.tv_area_stopTime:
                tv_area_stopTime.setText(DateUtil.CheckZero(year, month, day));
                UrlUtils.DDateto = DateUtil.CheckZero(year, month, day);
                break;
            case R.id.tv_area_startTimeMom:
                tv_area_startTimeMom.setText(DateUtil.CheckZero(year, month, day));
                UrlUtils.DDatefromMom = DateUtil.CheckZero(year, month, day);
                break;
            case R.id.tv_area_stopTimeMom:
                tv_area_stopTimeMom.setText(DateUtil.CheckZero(year, month, day));
                UrlUtils.DDatetoMom = DateUtil.CheckZero(year, month, day);
                break;
        }
    }
}

