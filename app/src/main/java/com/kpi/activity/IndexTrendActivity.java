package com.kpi.activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.gson.Gson;
import com.kpi.base.BaseActivity;
import com.kpi.bean.KpiTrend;
import com.kpi.bean.KpiTrendTime;
import com.kpi.utils.DateUtil;
import com.kpi.utils.JsonRequest;
import com.kpi.utils.NetUtils;
import com.kpi.utils.ToastUtils;
import com.kpi.utils.UrlUtils;
import com.kpi.view.MyMarkerView;
import com.storm.kpi.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * KPI指标趋势
 */
public class IndexTrendActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener,
        AdapterView.OnItemSelectedListener, Response.ErrorListener, Response.Listener<JSONObject> {
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private LineChart mLineChart;
    private RequestQueue queue;
    private KpiTrend mKpiTrend;
    private ProgressDialog dialog;
    private LinearLayout layout_date;
    private TextView sp_trend_date;
    private KpiTrendTime mKpiTrendTime;
    private LinearLayout start_time;
    private LinearLayout stop_time;
    private TextView tv_start_time;
    private TextView tv_stop_time;

    @Override
    public int getLayoutID() {
        return R.layout.activity_index_trend;
    }

    @Override
    public void initData() {
        UrlUtils.qSearchType = "1";
        queue = Volley.newRequestQueue(this);
        showProgressDialog();
        if (NetUtils.isNetworkConnected(this)) {
            RequestChartValue();
        }

    }

    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("指标趋势图");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void showProgressDialog() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("数据加载中...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    //初始化控件
    @Override
    public void initView() {
        mLineChart = (LineChart) findViewById(R.id.lineChart);
        XAxis xAxis = mLineChart.getXAxis();
        //设置X轴的文字在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置描述文字
        mLineChart.setDescription("");
        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
        mLineChart.setMarkerView(mv);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg_IndexTrend);
        layout_date = (LinearLayout) findViewById(R.id.layout_date);
        rb1 = (RadioButton) findViewById(R.id.rb_trend_today);
        rb2 = (RadioButton) findViewById(R.id.rb_trend_week);
        rb3 = (RadioButton) findViewById(R.id.rb_trend_month);
        rb4 = (RadioButton) findViewById(R.id.rb_trend_option);
        rb5 = (RadioButton) findViewById(R.id.rb_trend_detail);
        sp_trend_date = (TextView) findViewById(R.id.sp_trend_date);
        Spinner sp_type = (Spinner) findViewById(R.id.sp_trend_type);
        Spinner sp_time = (Spinner) findViewById(R.id.sp_trend_time);
        start_time = (LinearLayout) findViewById(R.id.layout_start);
        stop_time = (LinearLayout) findViewById(R.id.layout_stop);
        tv_start_time = (TextView) findViewById(R.id.tv_trend_start);
        tv_stop_time = (TextView) findViewById(R.id.tv_trend_stop);
        tv_start_time.setOnClickListener(this);
        tv_stop_time.setOnClickListener(this);
        tv_stop_time.setText(DateUtil.CurrentDay());
        setCurrentTime(tv_start_time);
        setCurrentTime(tv_stop_time);
        setCurrentTime(sp_trend_date);
        radioGroup.setOnCheckedChangeListener(this);
        sp_time.setOnItemSelectedListener(this);
        sp_type.setOnItemSelectedListener(this);

    }

    @Override
    public void initListener() {
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.sp_trend_type:
                UrlUtils.qSearchType = String.valueOf(position + 1);   //日图
                if (position == 0) {
                    layout_date.setVisibility(View.GONE);
                } else {
                    layout_date.setVisibility(View.VISIBLE);
                    hideTime();
                }
                break;
            case R.id.sp_trend_time:
                UrlUtils.imageType = String.valueOf(position + 1);  //小时图
                if (position == 1) {
                    setqSearchType();
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void RequestChartValue() {
        JsonRequest request = new JsonRequest(new UrlUtils().KpiTrend_url, null, this, this);
        queue.add(request);
    }

    @Override
    public void onResponse(JSONObject jsonObject) {
        mKpiTrend = new Gson().fromJson(jsonObject.toString(), KpiTrend.class);
        if (mKpiTrend.isSuccess()) {
            dialog.dismiss();
            UpdateChartValue();
        }
    }
    @Override
    public void onErrorResponse(VolleyError volleyError) {

    }


    private void UpdateChartValue() {
        KpiTrend.DataEntity dateEntity = mKpiTrend.getData();
        List<KpiTrend.DataEntity.DataListDetailEntity> list = dateEntity.getDataListDetail();
        ArrayList<String> xValues = new ArrayList<>();
        //模拟第二组组y轴数据(存放y轴数据的是一个Entry的ArrayList) 他是构建LineDataSet的参数之一
        ArrayList<Entry> scanCount = new ArrayList<>();
        ArrayList<Entry> customerCount = new ArrayList<>();
        ArrayList<Entry> addCount = new ArrayList<>();
        for (int i = 0, count = list.size(); i < count; i++) {
            //时间-->X轴
            xValues.add(list.get(i).getDateMd());
            //扫码件数
            scanCount.add(new Entry(list.get(i).getScanCount(), i));
            //扫码人数
            customerCount.add(new Entry(list.get(i).getCustomerCount(), i));
            //注册人数
            addCount.add(new Entry(list.get(i).getAddCount(), i));
        }
        LineDataSet scanCountSet = new LineDataSet(scanCount, "扫码件数");
        scanCountSet.setCircleRadius(5f);
        scanCountSet.setColor(Color.RED);
        scanCountSet.setHighLightColor(Color.RED);

        LineDataSet customerCountSet = new LineDataSet(customerCount, "扫码人数");
        customerCountSet.setCircleRadius(5f);
        customerCountSet.setColor(Color.BLUE);
        customerCountSet.setHighLightColor(Color.BLUE);

        LineDataSet addCountSet = new LineDataSet(addCount, "注册人数");
        addCountSet.setCircleRadius(5f);
        addCountSet.setColor(Color.GREEN);
        addCountSet.setHighLightColor(Color.GREEN);


        //构建一个类型为LineDataSet的ArrayList 用来存放所有y的LineDataSet
        // 他是构建最终加入LineChart数据集所需要的参数
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(scanCountSet);
        dataSets.add(customerCountSet);
        dataSets.add(addCountSet);

        //构建一个LineData 将dataSets放入
        LineData lineData = new LineData(xValues, dataSets);
        mLineChart.animateX(2000); // 立即执行的动画,x轴
        mLineChart.animateY(2000); // 立即执行的动画,Y轴
        mLineChart.setDragEnabled(true);// 是否可以拖拽
        mLineChart.setScaleEnabled(true);// 是否可以缩放
        //设置不绘画值
        lineData.setDrawValues(false);
        //将数据插入
        mLineChart.setData(lineData);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_trend_today:           //10天
                if (!UrlUtils.imageType.equals("2")) {
                    setqSearchType("1");
                } else {
                    setqSearchType();
                }
                rb1.setChecked(true);
                hideTime();
                break;
            case R.id.rb_trend_week:          //周
                if (!UrlUtils.imageType.equals("2")) {
                    setqSearchType("2");
                } else {
                    setqSearchType();
                }
                rb2.setChecked(true);
                hideTime();
                break;
            case R.id.rb_trend_month:        //月
                if (!UrlUtils.imageType.equals("2")) {
                    setqSearchType("3");
                } else {
                    setqSearchType();
                }
                rb3.setChecked(true);
                hideTime();
                break;
            case R.id.rb_trend_option:    //自选
                //ToastUtils.show(this, "请选择开始日和结束日");
                UrlUtils.qSearchType = "4";
                rb4.setChecked(true);
                showTime();
                break;
            case R.id.rb_trend_detail:        //详细
                UrlUtils.pDate = sp_trend_date.getText().toString();
                if (!UrlUtils.imageType.equals("2")) {
                    UrlUtils.qSearchType = "5";
                    RequestChartValue();
                } else {
                    UrlUtils.qSearchType = "5";
                    RequestCharHourValue();
                }
                rb5.setChecked(true);
                hideTime();
                break;
        }
    }

    private void setqSearchType() {
        UrlUtils.qSearchType = "5";
        UrlUtils.pDate = sp_trend_date.getText().toString();
        RequestCharHourValue();
    }

    private void setqSearchType(String qSearchType) {
        UrlUtils.qSearchType = qSearchType;
        RequestChartValue();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sp_trend_date:
                showDateDialog(v);
                break;
            case R.id.tv_trend_start:
                showDateDialog(v);
                break;
            case R.id.tv_trend_stop:
                showDateDialog(v);
                break;
        }
    }

    //小时图
    private void RequestCharHourValue() {
        JsonRequest request = new JsonRequest(new UrlUtils().KpiTrend_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                mKpiTrendTime = new Gson().fromJson(jsonObject.toString(), KpiTrendTime.class);
                if (mKpiTrendTime.isSuccess()) {
                    UpdateChartHourValue();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
            }
        });
        queue.add(request);
    }

    private void UpdateChartHourValue() {
        KpiTrendTime.DataEntity dataEntityHour = mKpiTrendTime.getData();
        List<KpiTrendTime.DataEntity.DataListDetailEntity> listHour = dataEntityHour.getDataListDetail();
        ArrayList<String> xValues = new ArrayList<>();
        //模拟第二组组y轴数据(存放y轴数据的是一个Entry的ArrayList) 他是构建LineDataSet的参数之一
        ArrayList<Entry> scanCount = new ArrayList<>();
        ArrayList<Entry> customerCount = new ArrayList<>();
        ArrayList<Entry> addCount = new ArrayList<>();
        for (int i = 0, count = listHour.size(); i < count; i++) {
            //时间(小时)-->X轴
            xValues.add(listHour.get(i).getDHour() + ":00");
            //扫码件数
            scanCount.add(new Entry(listHour.get(i).getScanCount(), i));
            //扫码人数
            customerCount.add(new Entry(listHour.get(i).getCustomerCount(), i));
            //注册人数
            addCount.add(new Entry(listHour.get(i).getAddCount(), i));
        }
        LineDataSet scanCountSet = new LineDataSet(scanCount, "扫码件数");
        scanCountSet.setColor(Color.RED);
        scanCountSet.setHighLightColor(Color.RED);


        LineDataSet customerCountSet = new LineDataSet(customerCount, "扫码人数");
        customerCountSet.setColor(Color.BLUE);
        customerCountSet.setHighLightColor(Color.BLUE);

        LineDataSet addCountSet = new LineDataSet(addCount, "注册人数");
        addCountSet.setColor(Color.GREEN);
        addCountSet.setHighLightColor(Color.GREEN);


        //构建一个类型为LineDataSet的ArrayList 用来存放所有y的LineDataSet
        // 他是构建最终加入LineChart数据集所需要的参数
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(scanCountSet);
        dataSets.add(customerCountSet);
        dataSets.add(addCountSet);

        //构建一个LineData 将dataSets放入
        LineData lineData = new LineData(xValues, dataSets);
        mLineChart.animateX(2000); // 立即执行的动画,x轴
        mLineChart.animateY(2000); // 立即执行的动画,Y轴
        mLineChart.setDragEnabled(true);// 是否可以拖拽
        mLineChart.setScaleEnabled(true);// 是否可以缩放
        //设置不绘画值
        lineData.setDrawValues(false);
        //将数据插入
        mLineChart.setData(lineData);
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
            case R.id.sp_trend_date:
                sp_trend_date.setText(DateUtil.CheckZero(year, month, day));
                break;
            case R.id.tv_trend_start:
                tv_start_time.setText(DateUtil.CheckZero(year, month, day));
                CheckCurrentTime(tv_start_time, tv_stop_time);
                break;
            case R.id.tv_trend_stop:
                tv_stop_time.setText(DateUtil.CheckZero(year, month, day));
                CheckCurrentTime(tv_start_time, tv_stop_time);
                break;
        }
    }

    //检查结束日应该晚于开始日
    private void CheckCurrentTime(TextView tv_startTime, TextView tv_stopTime) {
        if (DateUtil.CheckCurrentTime(tv_startTime, tv_stopTime) && DateUtil.checkStopTime(tv_stopTime.getText().toString())) {
            UrlUtils.pDateFrom = tv_startTime.getText().toString();   //开始日期
            UrlUtils.pDateTo = tv_stopTime.getText().toString();   //结束日期
            UpdateChartValue();
        } else {
            ToastUtils.showMessage(this, "你自选的时间有误！");
        }
    }


    //移除开始日和结束日
    private void hideTime() {
        start_time.setVisibility(View.GONE);
        stop_time.setVisibility(View.GONE);
    }

    //显示开始日和结束日
    private void showTime() {
        start_time.setVisibility(View.VISIBLE);
        stop_time.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300);
        start_time.setAnimation(alphaAnimation);
        stop_time.setAnimation(alphaAnimation);
    }


    //设置为当前时间
    private void setCurrentTime(TextView v) {
        v.setText(DateUtil.CurrentDay());
    }


}