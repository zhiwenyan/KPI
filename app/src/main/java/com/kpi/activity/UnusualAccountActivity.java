package com.kpi.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kpi.adapter.AccountListViewAdapter;
import com.kpi.base.BaseActivity;
import com.kpi.bean.Account;
import com.kpi.bean.AccountIndex;
import com.kpi.utils.DateUtil;
import com.kpi.utils.DialogUtils;
import com.kpi.utils.JsonRequest;
import com.kpi.utils.ListViewUtils;
import com.kpi.utils.ToastUtils;
import com.kpi.utils.UrlUtils;
import com.storm.kpi.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 异常账户
 */
public class UnusualAccountActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private TextView tv_account_date;
    private ListView mListView;
    private RequestQueue queue;
    private AccountIndex accountIndex;
    private TextView tv_loading;
    private ArrayList<Account> accountLists;
    private ProgressBar pb_loading;
    private TextView tv_day_count;     //日扫码量



    @Override
    public void initToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("日扫码异常");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_unusual_account;
    }

    @Override
    public void initView() {
        tv_account_date = (TextView) findViewById(R.id.tv_account_date);
        tv_account_date.setText(DateUtil.CurrentDay());
        mListView = (ListView) findViewById(R.id.list_account);
        Button button = (Button) findViewById(R.id.btn_unnsual_reference);
        tv_loading = (TextView) findViewById(R.id.tv_account_loading);
        pb_loading = (ProgressBar) findViewById(R.id.pb_loading);
        TextView add = (TextView) findViewById(R.id.add);   //增加日扫码量
        TextView reduce = (TextView) findViewById(R.id.reduce); //减少日扫码量
        tv_day_count = (TextView) findViewById(R.id.tv_day_count);
        tv_loading.setOnClickListener(this);
        button.setOnClickListener(this);
        tv_account_date.setOnClickListener(this);
        mListView.setOnItemClickListener(this);
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        tv_loading.setVisibility(View.INVISIBLE);
        pb_loading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        queue = Volley.newRequestQueue(this);
        accountLists = new ArrayList<>();
        UrlUtils.page = 0;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_account_date:
                showDateDialog();
                break;
            case R.id.btn_unnsual_reference:
                UrlUtils.page = 0;
                UrlUtils.limit = tv_day_count.getText().toString();
                accountLists = new ArrayList<>();
                requestAccountData();
                showProgressDialog();
                tv_loading.setText("点击加载更多...");
                tv_loading.setClickable(true);
                break;
            case R.id.tv_account_loading:
                ++UrlUtils.page;
                requestAccountData();
                tv_loading.setVisibility(View.INVISIBLE);
                pb_loading.setVisibility(View.VISIBLE);
                break;
            case R.id.add:
                int add = Integer.parseInt(tv_day_count.getText().toString());
                tv_day_count.setText(String.valueOf(++add));
                break;
            case R.id.reduce:
                int reduce = Integer.parseInt(tv_day_count.getText().toString());
                tv_day_count.setText(String.valueOf(--reduce));
                break;
        }
    }

    private void showProgressDialog() {
        DialogUtils.showProgressDialog(this, "查询中,请稍候...");
    }

    private void requestAccountData() {
        JsonRequest request = new JsonRequest(new UrlUtils().Account_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                accountIndex = new Gson().fromJson(jsonObject.toString(), AccountIndex.class);
                if (accountIndex.isSuccess()) {
                    UpdateAccount();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ToastUtils.showMessage(UnusualAccountActivity.this, "连接超时");
            }
        });
        //添加到队列中
        queue.add(request);
    }

    private void UpdateAccount() {
        Account account;
        List<AccountIndex.DataEntity.DataListAscEntity> lists = accountIndex.getData().getDataListAsc();
        if (lists.size() != 0) {
            DialogUtils.dissmissProgressDialog();
            pb_loading.setVisibility(View.INVISIBLE);
            for (int i = 0, count = lists.size(); i < count; i++) {
                account = new Account();
                account.setAccountId(lists.get(i).getCustomerId());
                account.setCount(String.valueOf(lists.get(i).getCount()));
                account.setDetail("详细");
                accountLists.add(account);
            }
            tv_loading.setVisibility(View.VISIBLE);
            AccountListViewAdapter adapter = new AccountListViewAdapter(this, accountLists);
            mListView.setAdapter(adapter);
            ListViewUtils.setListViewHeight(mListView);
        } else {
            pb_loading.setVisibility(View.INVISIBLE);
            tv_loading.setVisibility(View.VISIBLE);
            tv_loading.setText("已加最多...");
            //tv_loading.setClickable(false);
        }
    }

    //日期选择框
    private void showDateDialog() {
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                CheckMonthAndDay(year, monthOfYear, dayOfMonth);
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }


    private void CheckMonthAndDay(int year, int month, int day) {
        tv_account_date.setText(DateUtil.CheckZero(year, month + 1, day));
        UrlUtils.DDateTime = tv_account_date.getText().toString().trim();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        accountLists.get(position).getAccountId();
        Intent intent = new Intent(this, AccountDetailActivity.class);
        intent.putExtra("accountId", accountLists.get(position).getAccountId());
        startActivity(intent);
    }
}
