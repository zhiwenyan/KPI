package com.kpi.fragment;


import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.kpi.activity.AreaPerformanceActivity;
import com.kpi.activity.IndexTrendActivity;
import com.kpi.activity.KpiIndexActivity;
import com.kpi.activity.ProductPerformanceActivity;
import com.kpi.activity.UnusualAccountActivity;
import com.kpi.base.BaseFragment;
import com.kpi.bean.KpiIndex;
import com.kpi.utils.JsonRequest;
import com.kpi.utils.NetUtils;
import com.kpi.utils.ToastUtils;
import com.kpi.utils.UrlUtils;
import com.storm.kpi.R;

import org.json.JSONObject;

/**
 * 动态智码Fragment
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener, Response.Listener<JSONObject> {
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
    private KpiIndex mKpiIndex;

    @Override
    public int getLayoutID() {
        return R.layout.content_main;
    }

    @Override
    public void initView() {
        //设置swipeRefresh下拉图标颜色
        swipeRefreshLayout = findView(R.id.home_refresh);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(this);
        LinearLayout KpiIndex = findView(R.id.layout_kpiIndex); //重要KPI指标
        LinearLayout indexTrend = findView(R.id.layout_IndexTrend);  //指标趋势
        LinearLayout areaPer = findView(R.id.layout_area);     //区域表现
        LinearLayout productPer = findView(R.id.layout_product);  //产品表现
        LinearLayout unusualAccount = findView(R.id.layout_unusual);  //异常账户
        KpiIndex.setOnClickListener(this);
        indexTrend.setOnClickListener(this);
        areaPer.setOnClickListener(this);
        productPer.setOnClickListener(this);
        unusualAccount.setOnClickListener(this);

        tv_ScanCountToday = findView(R.id.tv_kpi_ScanCountToday);
        tv_ScanCountTodayMom = findView(R.id.tv_kpi_ScanCountTodayMom);
        tv_ScanCountWeekName = findView(R.id.tv_kpi_ScanCountWeekName);
        tv_ScanCountWeek = findView(R.id.tv_kpi_ScanCountWeek);
        tv_ScanCountWeekMom = findView(R.id.tv_kpi_ScanCountWeekMom);
        tv_ScanCountMonthName = findView(R.id.tv_kpi_ScanCountMonthName);
        tv_ScanCountMonth = findView(R.id.tv_kpi_ScanCountMonth);
        tv_ScanCountMonthMom = findView(R.id.tv_kpi_ScanCountMonthMom);
        tv_ScanCountYearName = findView(R.id.tv_kpi_ScanCountYearName);
        tv_ScanCountYear = findView(R.id.tv_kpi_ScanCountYear);
        tv_ScanCountYearMom = findView(R.id.tv_kpi_ScanCountYearMom);
        tv_CustomerCountToday = findView(R.id.tv_kpi_CustomerCountToday);
        tv_CustomerCountTodayMom = findView(R.id.tv_kpi_CustomerCountTodayMom);
        tv_CustomerCountWeekName = findView(R.id.tv_kpi_CustomerCountWeekName);
        tv_CustomerCountWeek = findView(R.id.tv_kpi_CustomerCountWeek);
        tv_CustomerCountWeekMom = findView(R.id.tv_kpi_CustomerCountWeekMom);
        tv_CustomerCountMonthName = findView(R.id.tv_kpi_CustomerCountMonthName);
        tv_CustomerCountMonth = findView(R.id.tv_kpi_CustomerCountMonth);
        tv_CustomerCountMonthMom = findView(R.id.tv_kpi_CustomerCountMonthMom);
        tv_CustomerCountYearName = findView(R.id.tv_kpi_CustomerCountYearName);
        tv_CustomerCountYear = findView(R.id.tv_kpi_CustomerCountYear);
        tv_CustomerCountYearMom = findView(R.id.tv_kpi_CustomerCountYearMom);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        UrlUtils.qSearchType = "1";
        refresh();

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.layout_kpiIndex:
                intent = new Intent(getActivity(), KpiIndexActivity.class);
                break;
            case R.id.layout_IndexTrend:
                intent = new Intent(getActivity(), IndexTrendActivity.class);
                break;
            case R.id.layout_area:
                intent = new Intent(getActivity(), AreaPerformanceActivity.class);
                break;
            case R.id.layout_product:
                intent = new Intent(getActivity(), ProductPerformanceActivity.class);
                break;
            case R.id.layout_unusual:
                intent = new Intent(getActivity(), UnusualAccountActivity.class);
                break;
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @Override
    public void onRefresh() {
        RequestKpiIndex();
    }

    //请求KPI数据
    private void RequestKpiIndex() {
        if (NetUtils.isNetworkConnected(getActivity())) {
            JsonRequest jsonRequest = new JsonRequest(UrlUtils.KpiIndex_url, null, this, null);
            //添加到请求队列中
            queue.add(jsonRequest);
        }
    }

    @Override
    public void onResponse(JSONObject jsonObject) {
        mKpiIndex = new Gson().fromJson(jsonObject.toString(), KpiIndex.class);
        if (mKpiIndex.isSuccess()) {
            UpdateKpiIndexValue();
        }
    }

    //更新Kpi指数数据
    private void UpdateKpiIndexValue() {
        KpiIndex.DataEntity mDataEntity = mKpiIndex.getData();
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
        } else {
            ToastUtils.show(getActivity());
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
