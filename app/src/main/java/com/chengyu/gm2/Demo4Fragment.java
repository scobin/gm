package com.chengyu.gm2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chengyu on 2016/12/28.
 */

public class Demo4Fragment extends DemoBaseFragment{
    @Override
    protected void updateUI() {

    }

    public Demo4Fragment() {
        // Required empty public constructor
    }

    public static Demo4Fragment newInstance(Bundle args) {
        Demo4Fragment fragment = new Demo4Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_demo4, container, false);

        return mRootView;
    }
}
