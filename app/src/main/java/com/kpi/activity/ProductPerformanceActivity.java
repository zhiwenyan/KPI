package com.kpi.activity;

import android.app.DatePickerDialog;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
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
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kpi.adapter.ProductListViewAdapter;
import com.kpi.base.BaseActivity;
import com.kpi.bean.ProductIndex;
import com.kpi.utils.DateUtil;
import com.kpi.utils.DialogUtils;
import com.kpi.utils.JsonRequest;
import com.kpi.utils.ListViewUtils;
import com.kpi.utils.NetUtils;
import com.kpi.utils.ToastUtils;
import com.kpi.utils.UrlUtils;
import com.storm.kpi.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 产品表现
 */
public class ProductPerformanceActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener, Response.ErrorListener, Response.Listener<JSONObject> {
    private ListView mListView;
    private RequestQueue queue;
    private LinearLayout mLinearLayout;
    private TextView tv_product_startTime;
    private TextView tv_product_stopTime;
    private TextView tv_product_startTimeMom;
    private TextView tv_product_stopTimeMom;

    @Override
    public int getLayoutID() {
        return R.layout.activity_product_performance;
    }
    @Override
    public void initView() {
        mListView = (ListView) findViewById(R.id.Product_ListView);
        mLinearLayout = (LinearLayout) findViewById(R.id.show_hide_product_layout);
        RadioButton rb_product_select = (RadioButton) findViewById(R.id.rb_product_select);
        RadioGroup rg_product = (RadioGroup) findViewById(R.id.rg_product);
        RadioButton rb_product_today = (RadioButton) findViewById(R.id.rb_product_today);
        rb_product_today.setChecked(true);
        UrlUtils.product_btn = "1";
        tv_product_startTime = (TextView) findViewById(R.id.tv_area_startTime);
        tv_product_stopTime = (TextView) findViewById(R.id.tv_area_stopTime);
        tv_product_startTimeMom = (TextView) findViewById(R.id.tv_area_startTimeMom);
        tv_product_stopTimeMom = (TextView) findViewById(R.id.tv_area_stopTimeMom);
        rb_product_select.setOnCheckedChangeListener(this);
        rg_product.setOnCheckedChangeListener(this);

        tv_product_startTime.setOnClickListener(this);
        tv_product_stopTime.setOnClickListener(this);
        tv_product_startTimeMom.setOnClickListener(this);
        tv_product_stopTimeMom.setOnClickListener(this);


        Spinner sp_product_select = (Spinner) findViewById(R.id.sp_product_select);
        Spinner sp_product_areaselect = (Spinner) findViewById(R.id.sp_product_areaselect);

//      统一冰红茶[柠檬]	     CB
//      统一绿茶[茉莉]	            CL
//      饮养四季冰糖雪梨[梨汁饮料]   GB
//      统一鲜橙多[橙汁饮料]         GX
//      统一阿萨姆[原味奶茶]	     ZA
        if (sp_product_select != null) {
            sp_product_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 1:
                            UrlUtils.product = "CB";
                            break;
                        case 2:
                            UrlUtils.product = "CL";
                            break;
                        case 3:
                            UrlUtils.product = "GB";
                            break;
                        case 4:
                            UrlUtils.product = "GX";
                            break;
                        case 5:
                            UrlUtils.product = "ZA";
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
        if (sp_product_areaselect != null) {
            sp_product_areaselect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position != 0) {
                        UrlUtils.area = parent.getSelectedItem().toString();
                    }
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

    @Override
    public void initData() {
        queue = Volley.newRequestQueue(this);
        UrlUtils.product = "";
        UrlUtils.area = "";
        showProgressDialog();
        if (NetUtils.isNetworkConnected(this)) {
            RequestProductData();
        }
    }


    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("产品表现");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    //设置成为当期日期
    private void setCurrentTime() {
        tv_product_startTime.setText(DateUtil.CurrentDay());
        tv_product_stopTime.setText(DateUtil.CurrentDay());
        tv_product_startTimeMom.setText(DateUtil.CurrentDay());
        tv_product_stopTimeMom.setText(DateUtil.CurrentDay());
    }

    private void RequestProductData() {
        JsonRequest request = new JsonRequest(new UrlUtils().Product_Url, null, this, this);
        queue.add(request);
    }

    @Override
    public void onResponse(JSONObject jsonObject) {
        ProductIndex.DataEntity product = new Gson().fromJson(jsonObject.toString(), ProductIndex.class).getData();
        if (product != null) {
            updateProduct(product);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
    }


    private void updateProduct(ProductIndex.DataEntity product) {
        ProductIndex.DataEntity.DataListTotilEntity p;
        ArrayList<ProductIndex.DataEntity.DataListTotilEntity> products = new ArrayList<>();
        if (product != null) {
            String url = "http://192.168.0.19:4444";
            ImageView img_productIndex = (ImageView) findViewById(R.id.img_productIndex);
            Glide.with(this).load(url + new StringBuffer(product.getImageurl())).into(img_productIndex);
            List<ProductIndex.DataEntity.DataListTotilEntity> lists = product.getDataListTotil();
            for (int i = 0, count = lists.size(); i < count; i++) {
                p = new ProductIndex.DataEntity.DataListTotilEntity();
                p.setProductName(lists.get(i).getProductName());
                p.setScanCount(lists.get(i).getScanCount());
                p.setScanCountMom(lists.get(i).getScanCountMom());
                p.setScanCustomerCount(lists.get(i).getScanCustomerCount());
                p.setScanCustomerCountMom(lists.get(i).getScanCustomerCountMom());
                products.add(p);
            }
            ProductListViewAdapter pa = new ProductListViewAdapter(products, ProductPerformanceActivity.this);
            mListView.setAdapter(pa);
            DialogUtils.dissmissProgressDialog();
        } else {
            ToastUtils.show(this);
        }
        ListViewUtils.setListViewHeight(mListView);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_product_today:
                UrlUtils.product_btn = "1";
                RequestProductData();
                break;
            case R.id.rb_product_week:
                UrlUtils.product_btn = "2";
                RequestProductData();
                break;
            case R.id.rb_product_mouth:
                UrlUtils.product_btn = "3";
                RequestProductData();
                break;
            case R.id.rb_product_select:    //自选
                UrlUtils.product_btn = "4";
                setCurrentTime();
                RequestProductData();
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            //布局可见
            mLinearLayout.setVisibility(View.VISIBLE);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500);
            mLinearLayout.setAnimation(alphaAnimation);
        } else {
            //移除布局
            mLinearLayout.setVisibility(View.GONE);
        }
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
                tv_product_startTime.setText(DateUtil.CheckZero(year, month, day));
                UrlUtils.DDatefrom = DateUtil.CheckZero(year, month, day);
                break;
            case R.id.tv_area_stopTime:
                tv_product_stopTime.setText(DateUtil.CheckZero(year, month, day));
                UrlUtils.DDateto = DateUtil.CheckZero(year, month, day);
                CheckCurrentTime(tv_product_startTime, tv_product_stopTime);
                break;
            case R.id.tv_area_startTimeMom:
                tv_product_startTimeMom.setText(DateUtil.CheckZero(year, month, day));
                UrlUtils.DDatefromMom = DateUtil.CheckZero(year, month, day);
                break;
            case R.id.tv_area_stopTimeMom:
                tv_product_stopTimeMom.setText(DateUtil.CheckZero(year, month, day));
                UrlUtils.DDatetoMom = DateUtil.CheckZero(year, month, day);
                CheckCurrentTime(tv_product_startTimeMom, tv_product_stopTimeMom);
                break;
        }
    }

    //检查结束日应该晚于开始日
    private void CheckCurrentTime(TextView tv_startTime, TextView tv_stopTime) {
        if (DateUtil.CheckCurrentTime(tv_startTime, tv_stopTime)) {
            RequestProductData();
        } else {
            ToastUtils.showMessage(this, "结束时间应该大于开始时间");
        }
    }

    private void showProgressDialog() {
        DialogUtils.showProgressDialog(this, "数据加载中...");
    }


}
