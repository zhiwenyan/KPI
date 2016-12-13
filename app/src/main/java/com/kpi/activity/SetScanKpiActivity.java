package com.kpi.activity;

import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.kpi.base.BaseActivity;
import com.storm.kpi.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SetScanKpiActivity extends BaseActivity implements View.OnClickListener, OptionsPickerView.OnOptionsSelectListener, TimePickerView.OnTimeSelectListener {
    private OptionsPickerView pvOptions;
    private ArrayList<String> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private EditText ed_set_scan_city;
    private EditText ed_set_scan_month;
    private TimePickerView pvTime;


    @Override
    public int getLayoutID() {
        return R.layout.activity_set_scan_kpi;
    }

    @Override
    public void initView() {
        ed_set_scan_city = findView(R.id.ed_set_scan_city);
        ed_set_scan_month = findView(R.id.ed_set_scan_month);
        //始终隐藏软键盘
        ed_set_scan_city.setInputType(InputType.TYPE_NULL);
        ed_set_scan_month.setInputType(InputType.TYPE_NULL);

//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(ed_set_scan_city.getWindowToken(), 0);
//        imm.hideSoftInputFromWindow(ed_set_scan_month.getWindowToken(), 0);
    }

    @Override
    public void initListener() {
        ed_set_scan_city.setOnClickListener(this);
        ed_set_scan_month.setOnClickListener(this);


    }

    @Override
    public void initData() {
        pvOptions = new OptionsPickerView(this);
        pvOptions.setOnoptionsSelectListener(this);
    }

    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("设置扫码KPI");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void showProvince() {
        //选项1
        options1Items.add("广东");
        options1Items.add("上海");
        options1Items.add("湖南");
        options1Items.add("广西");
        //选项2
        ArrayList<String> options2Items_01 = new ArrayList<>();
        options2Items_01.add("广州");
        options2Items_01.add("佛山");
        options2Items_01.add("东莞");
        options2Items_01.add("阳江");
        options2Items_01.add("珠海");
        ArrayList<String> options2Items_02 = new ArrayList<>();
        options2Items_02.add("静安区");
        options2Items_02.add("黄埔区");
        options2Items_02.add("浦东新区");
        options2Items_02.add("徐家汇");
        ArrayList<String> options2Items_03 = new ArrayList<>();
        options2Items_03.add("长沙");
        options2Items_03.add("岳阳");
        ArrayList<String> options2Items_04 = new ArrayList<>();
        options2Items_04.add("桂林");
        options2Items.add(options2Items_01);
        options2Items.add(options2Items_02);
        options2Items.add(options2Items_03);
        options2Items.add(options2Items_04);
        pvOptions.setTitle("选择城市");
        pvOptions.setPicker(options1Items, options2Items, true);//联动
        pvOptions.setCyclic(false);
        pvOptions.setCancelable(true);
        pvOptions.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ed_set_scan_city:
                showProvince();
                break;
            case R.id.ed_set_scan_month:
                showMonth();
                break;
        }
    }

    private void showMonth() {
        //时间选择器
        pvTime = new TimePickerView(this, TimePickerView.Type.YEAR_MONTH_DAY);
        //控制时间范围
        Calendar calendar = Calendar.getInstance();
        pvTime.setRange(calendar.get(Calendar.YEAR), calendar.get(Calendar.YEAR) + 10);
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);
        pvTime.setTitle("月份选择");
        pvTime.show();
        pvTime.setOnTimeSelectListener(this);
    }

    @Override
    public void onOptionsSelect(int options1, int option2, int options3) {
        ed_set_scan_city.setText(options1Items.get(options1) + options2Items.get(options1).get(option2));
    }

    @Override
    public void onTimeSelect(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        ed_set_scan_month.setText(simpleDateFormat.format(date));
    }
}
