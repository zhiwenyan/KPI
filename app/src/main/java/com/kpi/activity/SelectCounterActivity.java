package com.kpi.activity;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.kpi.baiduMap.PoiOverlay;
import com.kpi.base.BaseActivity;
import com.kpi.utils.DialogUtils;
import com.kpi.utils.NetUtils;
import com.kpi.utils.ToastUtils;
import com.storm.kpi.R;

/**
 * 门店查询 ————》使用百度地图SDK
 */
public class SelectCounterActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,
        View.OnClickListener, SearchView.OnQueryTextListener, OnGetPoiSearchResultListener,
        OnGetSuggestionResultListener, BDLocationListener, SearchView.OnCloseListener {
    //    private TextureMapView mMapView;
    private MapView mMapView;
    private LocationClient mLocClient;
    private BaiduMap mBaiduMap;
    private boolean isFirst = false;
    private SearchView searchView;
    private RadioGroup rg;
    private ImageView img_location;
    private PoiSearch mPoiSearch;
    private SuggestionSearch mSuggestionSearch;
    private int pageNum = 1;
    private int totalPageNum;
    private Button btn_poi_next;
    private Button btn_poi_pre;
    private FloatingActionButton fab;

    public SelectCounterActivity() {
    }


    @Override
    public int getLayoutID() {
        return R.layout.activity_select_counter;
    }

    @Override
    public void initListener() {
        img_location.setOnClickListener(this);
        rg.setOnCheckedChangeListener(this);
        mSuggestionSearch.setOnGetSuggestionResultListener(this);
        mPoiSearch.setOnGetPoiSearchResultListener(this);
        btn_poi_next.setOnClickListener(this);
        btn_poi_pre.setOnClickListener(this);
        searchView.setOnCloseListener(this);


    }

    @Override
    public void initData() {
        //获取地图控件引用
        mMapView = findView(R.id.bmapView);
        //创建POI检索实例
        mPoiSearch = PoiSearch.newInstance();
        mSuggestionSearch = SuggestionSearch.newInstance();
    }

    @Override
    public void initView() {
        //    SDKInitializer.initialize(this);
        rg = findView(R.id.rg);
        img_location = findView(R.id.img_location);
        searchView = findView(R.id.select_SearchView);
        btn_poi_next = findView(R.id.btn_poi_next);
        btn_poi_pre = findView(R.id.btn_poi_pre);
        fab = findView(R.id.fab_note);
        fab.setOnClickListener(this);
        searchView.setOnQueryTextListener(this);
        //   searchView.setIconified(false);//设置搜索框默认展开
        //  searchView.onActionViewExpanded();//表示在内容为空时不显示取消的x按钮，内容不为空时显示.
        searchView.setSubmitButtonEnabled(true);//是否显示确认搜索按钮


    }

    @Override
    public void initToolBar() {
        Toolbar selectCounter_toolbar = findView(R.id.selectCounter_toolbar);
        setSupportActionBar(selectCounter_toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.left);
        }
    }

    private void showProgressDialog() {
        DialogUtils.showProgressDialog(this, "正在定位...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (NetUtils.isNetworkConnected(this)) {
            getMyLocation();
        }
    }

    //获取实时位置
    private void getMyLocation() {
        isFirst = true;
        showProgressDialog();
        mBaiduMap = mMapView.getMap();
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        // 定位初始化
        mLocClient = new LocationClient(this);
        mLocClient.registerLocationListener(this);
        //LocationClientOption--->设置地图的属性
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setIsNeedAddress(true);  //设置需要位置
        option.setScanSpan(1000);
        mLocClient.setLocOption(option);
        //普通地图
        mLocClient.start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_location:
                getMyLocation();
                break;
            case R.id.btn_poi_next:
                setPoiValue(++pageNum);
                break;
            case R.id.btn_poi_pre:
                if (pageNum > 1) {
                    setPoiValue(--pageNum);
                }
                break;
            case R.id.fab_note:
                startActivity(new Intent(this, SignInNotesActivity.class));
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_map_normal:
                //普通地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.rb_map_sate:
                //卫星地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        setPoiValue(pageNum);
        return false;
    }

    private void setPoiValue(int num) {
        DialogUtils.showProgressDialog(this, "正在检索...");
        //发起检索请求
        mPoiSearch.searchInCity((new PoiCitySearchOption())
                .city("上海")
                .keyword("静安区北京西路")   //具体定位到那个地方检索
                .pageNum(num));
        mSuggestionSearch.requestSuggestion((new SuggestionSearchOption())    //建议检索
                .keyword("餐厅").city("上海"));
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }

    @Override
    public void onDestroy() {
        // 退出时销毁定位
        if (mLocClient != null) {
            mLocClient.stop();
            // 关闭定位图层
            mBaiduMap.setMyLocationEnabled(false);
            mMapView.onDestroy();
            mMapView = null;
        }
        if (mPoiSearch != null) {
            mPoiSearch.destroy();
        }
        if (mSuggestionSearch != null) {
            mSuggestionSearch.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onGetPoiResult(PoiResult result) {
        if (result == null
                || result.error == SearchResult.ERRORNO.RESULT_NOT_FOUND) {
            ToastUtils.showMessage(this, "未找到结果");
            return;
        }
        if (result.error == SearchResult.ERRORNO.NO_ERROR) {
            mBaiduMap.clear();
            PoiOverlay overlay = new MyPoiOverlay(mBaiduMap);  //标记
            mBaiduMap.setOnMarkerClickListener(overlay);
            overlay.setData(result);
            overlay.addToMap();
            overlay.zoomToSpan();
            this.totalPageNum = result.getTotalPageNum();
            btn_poi_pre.setVisibility(View.VISIBLE);
            btn_poi_next.setVisibility(View.VISIBLE);
            return;
        }
        DialogUtils.dissmissProgressDialog();
    }

    @Override
    public void onGetPoiDetailResult(PoiDetailResult result) {
        if (result.error != SearchResult.ERRORNO.NO_ERROR) {
            ToastUtils.showMessage(this, "抱歉，未找到结果");
        } else {
            ToastUtils.showMessage(this, result.getName() + ": " + result.getAddress());
        }
    }

    @Override
    public void onGetSuggestionResult(SuggestionResult res) {
        if (res == null || res.getAllSuggestions() == null) {
            return;
        }
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        if (bdLocation != null && isFirst) {
            ToastUtils.showMessage(this, "你当前的区域:" + bdLocation.getCity() + bdLocation.getDistrict());
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(bdLocation.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            LatLng ll = new LatLng(bdLocation.getLatitude(),
                    bdLocation.getLongitude());
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(ll).zoom(18.0f);
            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            isFirst = false;
        } else if (bdLocation.getCity() == null || bdLocation == null) {
            ToastUtils.showMessage(this, "定位失败,请你重新定位！");
        }
        DialogUtils.dissmissProgressDialog();
    }

    @Override
    public boolean onClose() {
        btn_poi_next.setVisibility(View.GONE);
        btn_poi_pre.setVisibility(View.GONE);
        return false;
    }


    private class MyPoiOverlay extends PoiOverlay {
        public MyPoiOverlay(BaiduMap baiduMap) {
            super(baiduMap);
        }

        @Override
        public boolean onPoiClick(int index) {
            super.onPoiClick(index);
            PoiInfo poi = getPoiResult().getAllPoi().get(index);
            mPoiSearch.searchPoiDetail((new PoiDetailSearchOption())
                    .poiUid(poi.uid));
            return true;
        }
    }
}
