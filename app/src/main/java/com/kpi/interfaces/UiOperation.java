package com.kpi.interfaces;

/**
 * UI操作接口
 */
public interface UiOperation {
    abstract int getLayoutID();

    abstract void initView();

    abstract void initListener();

    abstract void initData();

    abstract void initToolBar();

}
