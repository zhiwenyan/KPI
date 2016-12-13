package com.kpi.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kpi.adapter.AccountProductDayAdapter;
import com.kpi.base.BaseActivity;
import com.kpi.bean.AccountDetailIndex;
import com.kpi.bean.AccountScan;
import com.kpi.bean.AccountScanIndex;
import com.kpi.utils.JsonRequest;
import com.kpi.utils.ListViewUtils;
import com.kpi.utils.NetUtils;
import com.kpi.utils.ToastUtils;
import com.kpi.utils.UrlUtils;
import com.storm.kpi.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//账户详细
public class AccountDetailActivity extends BaseActivity {
    private RequestQueue queue;
    private AccountDetailIndex accountDetailIndex;
    private TextView tv_accountId;
    private TextView tv_accountName;
    private TextView tv_shop;
    private TextView tv_phone;
    private TextView tv_address;
    private ImageView img_account_detail;
    private AccountScanIndex accountScanIndex;
    private ListView list_record;


    @Override
    public void initData() {
        UrlUtils.accountId = getIntent().getStringExtra("accountId");  //客户Id;
        queue = Volley.newRequestQueue(this);
        if (NetUtils.isNetworkConnected(this)) {
            requestAccountDetail();
            requestProductDay();
        }

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_account_detail;
    }

    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("客户信息");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void initView() {
        tv_accountId = (TextView) findViewById(R.id.tv_account_id);
        tv_accountName = (TextView) findViewById(R.id.tv_account_name);
        tv_shop = (TextView) findViewById(R.id.tv_account_shopname);
        tv_phone = (TextView) findViewById(R.id.tv_account_phone);
        tv_address = (TextView) findViewById(R.id.tv_account_address);
        img_account_detail = (ImageView) findViewById(R.id.img_account_detail);
        list_record = (ListView) findViewById(R.id.list_record);
        Spinner sp_account_date = (Spinner) findViewById(R.id.sp_account_date);
        //进日扫码件数
        if (sp_account_date != null) {
            sp_account_date.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            UrlUtils.selectDay = "7";
                            requestAccountDetail();
                            break;
                        case 1:
                            UrlUtils.selectDay = "10";
                            requestAccountDetail();
                            break;
                        case 2:
                            UrlUtils.selectDay = "30";
                            requestAccountDetail();
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
        //近日产品分布
        Spinner sp_account_record = (Spinner) findViewById(R.id.sp_product_day);
        if (sp_account_record != null) {
            sp_account_record.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            UrlUtils.selectTime = "7";
                            requestProductDay();
                            break;
                        case 1:
                            UrlUtils.selectTime = "10";
                            requestProductDay();
                            break;
                        case 2:
                            UrlUtils.selectTime = "30";
                            requestProductDay();
                            break;
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


    /**
     * 请求客户客户扫码件数
     */
    private void requestAccountDetail() {
        JsonRequest jsonRequest = new JsonRequest(new UrlUtils().account_url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                accountDetailIndex = new Gson().fromJson(jsonObject.toString(), AccountDetailIndex.class);
                if (accountDetailIndex.isSuccess()) {
                    updateAccountScan();
                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ToastUtils.show(AccountDetailActivity.this);

            }
        });
        queue.add(jsonRequest);

    }

    private void updateAccountScan() {
        String url = "http://192.168.0.19:4444";  //请求的IP;
        String img_url = accountDetailIndex.getData().getImageurl();  //图片地址
        Glide.with(getApplicationContext()).load(url + new StringBuffer(img_url)).into(img_account_detail);
        //soapEntity--->客户信息
        AccountDetailIndex.DataEntity.CustomerSoapEntity soapEntity = accountDetailIndex.getData().getCustomerSoap();
        tv_accountId.setText(soapEntity.getCustomerId());
        tv_accountName.setText(soapEntity.getLastName());
        tv_phone.setText(soapEntity.getMobile());
        tv_shop.setText(String.valueOf(soapEntity.getServiceCounter()));
        tv_address.setText(soapEntity.getMobileArea());
    }

    /**
     * 请求日产品分布
     */
    private void requestProductDay() {
        JsonRequest jsonRequest = new JsonRequest(new UrlUtils().account_url2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                accountScanIndex = new Gson().fromJson(jsonObject.toString(), AccountScanIndex.class);
                if (accountScanIndex.isSuccess()) {
                    UpdateProductDay();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(jsonRequest);

    }


    private void UpdateProductDay() {
        AccountScan accountScan;
        ArrayList<AccountScan> accountScans = new ArrayList<>();
        List<AccountScanIndex.DataEntity.DetailListEntity> listEntities = accountScanIndex.getData().getDetailList();
        for (int i = 0, count = listEntities.size(); i < count; i++) {
            accountScan = new AccountScan();
            accountScan.setName(listEntities.get(i).getCustomerId());
            accountScan.setCount(String.valueOf(listEntities.get(i).getCount()) + "%");
            accountScan.setCountMom(listEntities.get(i).getCountMom());
            accountScans.add(accountScan);
        }
        AccountProductDayAdapter productDay = new AccountProductDayAdapter(this, accountScans);
        list_record.setAdapter(productDay);

        //重新计算ListView的高度
        ListViewUtils.setListViewHeight(list_record);
    }

}
