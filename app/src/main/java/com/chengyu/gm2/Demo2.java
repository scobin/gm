package com.chengyu.gm2;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Demo2 extends DemoBaseFragment implements View.OnClickListener {

    public static final String TAG = "Demo2";
    private TextView mTimeText;

    public Demo2() {
        // Required empty public constructor
    }

    public static Demo2 newInstance(Bundle args) {
        Demo2 fragment = new Demo2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_game2, container, false);
        mRootView.findViewById(R.id.test2_timer_start).setOnClickListener(this);
        mRootView.findViewById(R.id.test2_timer_stop).setOnClickListener(this);
        mTimeText = (TextView) mRootView.findViewById(R.id.test_timer);

        mCount = 0;
        mTimeText.setText("00.00");

        return mRootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.test2_timer_start:
                startTimer(false);
                mTimeText.setText("00.00");
                break;
            case R.id.test2_timer_stop:
                stopTimer();
                break;
        }
    }

    @Override
    protected void updateUI() {
        long ss = mCount/100;
        long ms = mCount - ss*100;
        mTimeText.setText(String.format("%1$d.%2$d", ss, ms));
    }
}
