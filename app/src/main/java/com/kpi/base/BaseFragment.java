package com.kpi.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.kpi.interfaces.UiOperation;


public abstract class BaseFragment extends Fragment implements UiOperation {
    public View rootView;
    public RequestQueue queue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutID(), null);
        queue = getRequestQueue();
        initView();
        initData();
        initListener();
        return rootView;
    }

    //查找View，省去强转操作
    protected <T> T findView(int id) {
        if (rootView != null) {
            T view = (T) rootView.findViewById(id);
            return view;
        }
        return null;
    }

    private RequestQueue getRequestQueue() {
        if (queue == null) {
            queue = Volley.newRequestQueue(getActivity());
        }
        return queue;
    }
}
