package com.kpi.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.kpi.interfaces.UiOperation;
import com.kpi.utils.AppManager;
import com.storm.kpi.R;

/**
 * 基类Activity
 */
public abstract class BaseActivity extends AppCompatActivity implements UiOperation {
    public AppManager appManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        appManager = AppManager.getAppManager();
        appManager.addActivity(this);
        initView();
        initData();
        initToolBar();
        initListener();
    }

    //查找View，省去强转操作
    protected <T> T findView(int id) {
        T view = (T) findViewById(id);
        return view;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();  //gc,释放资源

    }

    /**
     * ToolBar返回的箭头
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            appManager.finishActivity(this);
            this.overridePendingTransition(0, R.anim.fade_out);
        }
        return false;
    }

    //返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            appManager.finishActivity(this);
            this.overridePendingTransition(0, R.anim.fade_out);
            return true;
        }
        return false;
    }
}
