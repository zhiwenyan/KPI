package com.kpi.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kpi.base.BaseActivity;
import com.kpi.bean.KpiIndex;
import com.kpi.utils.JsonRequest;
import com.kpi.utils.NetUtils;
import com.kpi.utils.ToastUtils;
import com.kpi.utils.UrlUtils;
import com.storm.kpi.R;

import org.json.JSONObject;

/**
 * 重要KPI指标  -->KPI指数
 */
public class KpiIndexActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, Response.Listener<JSONObject>, Response.ErrorListener {
    private SwipeRefreshLayout swipeRefreshLayout;

    private TextView tv_ScanCountToday;    //当日扫码件数
    private TextView tv_ScanCountTodayMom;

    private TextView tv_ScanCountWeekName;    //7日(十万)
    private TextView tv_ScanCountWeek;       //7日(十万)————》value
    private TextView tv_ScanCountWeekMom;    //日环

    private TextView tv_ScanCountMonthName;  //月(十万)
    private TextView tv_ScanCountMonth;       //月(十万)————》value
    private TextView tv_ScanCountMonthMom;   //月环

    private TextView tv_ScanCountYearName;  //年(十万)
    private TextView tv_ScanCountYear;      //年(十万)————》value
    private TextView tv_ScanCountYearMom;   //年环

    private TextView tv_CustomerCountToday; //当日扫码人数
    private TextView tv_CustomerCountTodayMom;

    private TextView tv_CustomerCountWeekName; //7日
    private TextView tv_CustomerCountWeek;  //7日 ——》value
    private TextView tv_CustomerCountWeekMom; //环

    private TextView tv_CustomerCountMonthName; //当月
    private TextView tv_CustomerCountMonth;   //当月-->value
    private TextView tv_CustomerCountMonthMom;   //环

    private TextView tv_CustomerCountYearName;  //年(十万)
    private TextView tv_CustomerCountYear;  //年(十万)  ---》value
    private TextView tv_CustomerCountYearMom;  //年(十万)  ————》环


    private TextView tv_ScanQuantityCount;  //累计扫码件数
    private TextView tv_ScanCustomerCount;  //累计扫码人数
    private TextView tv_AddCustomerCount;   //累计注册人数

    private RequestQueue queue;     //请求队列
    private KpiIndex mKpiIndex;


    @Override
    public void initData() {
        queue = Volley.newRequestQueue(this);
        if (NetUtils.isNetworkConnected(this)) {
            refresh();
        }
    }


    @Override
    public int getLayoutID() {
        return R.layout.activity_kpi;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("KPI指数");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    //初始化控件
    @Override
    public void initView() {
        //设置swipeRefresh下拉图标颜色
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(this);

        tv_ScanCountToday = (TextView) findViewById(R.id.tv_kpi_ScanCountToday);
        tv_ScanCountTodayMom = (TextView) findViewById(R.id.tv_kpi_ScanCountTodayMom);
        tv_ScanCountWeekName = (TextView) findViewById(R.id.tv_kpi_ScanCountWeekName);
        tv_ScanCountWeek = (TextView) findViewById(R.id.tv_kpi_ScanCountWeek);
        tv_ScanCountWeekMom = (TextView) findViewById(R.id.tv_kpi_ScanCountWeekMom);
        tv_ScanCountMonthName = (TextView) findViewById(R.id.tv_kpi_ScanCountMonthName);
        tv_ScanCountMonth = (TextView) findViewById(R.id.tv_kpi_ScanCountMonth);
        tv_ScanCountMonthMom = (TextView) findViewById(R.id.tv_kpi_ScanCountMonthMom);
        tv_ScanCountYearName = (TextView) findViewById(R.id.tv_kpi_ScanCountYearName);
        tv_ScanCountYear = (TextView) findViewById(R.id.tv_kpi_ScanCountYear);
        tv_ScanCountYearMom = (TextView) findViewById(R.id.tv_kpi_ScanCountYearMom);
        tv_CustomerCountToday = (TextView) findViewById(R.id.tv_kpi_CustomerCountToday);
        tv_CustomerCountTodayMom = (TextView) findViewById(R.id.tv_kpi_CustomerCountTodayMom);
        tv_CustomerCountWeekName = (TextView) findViewById(R.id.tv_kpi_CustomerCountWeekName);
        tv_CustomerCountWeek = (TextView) findViewById(R.id.tv_kpi_CustomerCountWeek);
        tv_CustomerCountWeekMom = (TextView) findViewById(R.id.tv_kpi_CustomerCountWeekMom);
        tv_CustomerCountMonthName = (TextView) findViewById(R.id.tv_kpi_CustomerCountMonthName);
        tv_CustomerCountMonth = (TextView) findViewById(R.id.tv_kpi_CustomerCountMonth);
        tv_CustomerCountMonthMom = (TextView) findViewById(R.id.tv_kpi_CustomerCountMonthMom);
        tv_CustomerCountYearName = (TextView) findViewById(R.id.tv_kpi_CustomerCountYearName);
        tv_CustomerCountYear = (TextView) findViewById(R.id.tv_kpi_CustomerCountYear);
        tv_CustomerCountYearMom = (TextView) findViewById(R.id.tv_kpi_CustomerCountYearMom);
        tv_ScanQuantityCount = (TextView) findViewById(R.id.tv_kpi_ScanQuantityCount);
        tv_ScanCustomerCount = (TextView) findViewById(R.id.tv_kpi_ScanCustomerCount);
        tv_AddCustomerCount = (TextView) findViewById(R.id.tv_kpi_AddCustomerCount);

    }


    @Override
    public void onRefresh() {
        if (NetUtils.isNetworkConnected(this)) {
            RequestKpiIndex();
        }
    }

    //请求KPI数据
    private void RequestKpiIndex() {
        final JsonRequest jsonRequest = new JsonRequest(UrlUtils.KpiIndex_url, null, this, this);
        //添加到请求队列中
        queue.add(jsonRequest);

    }

    @Override
    public void onResponse(JSONObject jsonObject) {
        mKpiIndex = new Gson().fromJson(jsonObject.toString(), KpiIndex.class);
        if (mKpiIndex.isSuccess()) {
            UpdateKpiIndexValue();
        }
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        ToastUtils.showMessage(this, "服务器似乎出了点问题!");
    }

    KpiIndex.DataEntity mDataEntity;

    //更新Kpi指数数据
    private void UpdateKpiIndexValue() {
        mDataEntity = mKpiIndex.getData();
        if (mDataEntity != null) {
            closeRefresh();
            KpiIndex.DataEntity.DataListEntity dataListEntity = mDataEntity.getDataList();
            tv_ScanCountToday.setText(String.valueOf(dataListEntity.getScanCountToday()));
            tv_ScanCountTodayMom.setText(dataListEntity.getScanCountTodayMom());
            tv_ScanCountWeekName.setText((dataListEntity.getScanCountWeekName()) + ":");
            tv_ScanCountWeek.setText(String.valueOf(dataListEntity.getScanCountWeek()));
            tv_ScanCountWeekMom.setText(dataListEntity.getScanCountWeekMom());
            tv_ScanCountMonthName.setText((dataListEntity.getScanCountMonthName()) + ":");
            tv_ScanCountMonth.setText(String.valueOf(dataListEntity.getScanCountMonth()));
            tv_ScanCountMonthMom.setText(dataListEntity.getScanCountMonthMom());
            tv_ScanCountYearName.setText((dataListEntity.getScanCountYearName()) + ":");
            tv_ScanCountYear.setText(String.valueOf(dataListEntity.getScanCountYear()));
            tv_ScanCountYearMom.setText(dataListEntity.getScanCountYearMom());
            tv_CustomerCountToday.setText(String.valueOf(dataListEntity.getCustomerCountToday()));
            tv_CustomerCountTodayMom.setText(dataListEntity.getCustomerCountTodayMom());
            tv_CustomerCountWeekName.setText(dataListEntity.getCustomerCountWeekName());
            tv_CustomerCountWeek.setText(String.valueOf(dataListEntity.getCustomerCountWeek()));
            tv_CustomerCountWeekMom.setText(dataListEntity.getCustomerCountWeekMom());
            tv_CustomerCountMonthName.setText(dataListEntity.getCustomerCountMonthName() + ":");
            tv_CustomerCountMonth.setText(String.valueOf(dataListEntity.getCustomerCountMonth()));
            tv_CustomerCountMonthMom.setText(dataListEntity.getCustomerCountMonthMom());
            tv_CustomerCountYearName.setText(dataListEntity.getCustomerCountYearName() + ":");
            tv_CustomerCountYear.setText(String.valueOf(dataListEntity.getCustomerCountYear()));
            tv_CustomerCountYearMom.setText(dataListEntity.getCustomerCountYearMom());
            tv_ScanQuantityCount.setText(String.valueOf(dataListEntity.getScanQuantityCount()));
            tv_ScanCustomerCount.setText(String.valueOf(dataListEntity.getScanCustomerCount()));
            tv_AddCustomerCount.setText(String.valueOf(dataListEntity.getAddCustomerCount()));
        } else {
            ToastUtils.show(this);
        }
    }

    private void refresh() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                RequestKpiIndex();
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    private void closeRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
