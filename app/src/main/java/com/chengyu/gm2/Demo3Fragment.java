package com.chengyu.gm2;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Demo3Fragment extends DemoBaseFragment implements View.OnClickListener {

    public static final String TAG = "Demo3Fragment";
    private TextView mTarget;
    private TextView mTimeText;

    public Demo3Fragment() {
        // Required empty public constructor
    }

    public static Demo3Fragment newInstance(Bundle args) {
        Demo3Fragment fragment = new Demo3Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void updateUI() {
        long ss = mCount/100;
        long ms = mCount - ss*100;
        mTimeText.setText(String.format("%1$d.%2$d", ss, ms));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_demo3, container, false);
        mRootView.findViewById(R.id.demo3_btn1).setOnClickListener(this);
        mRootView.findViewById(R.id.demo3_btn2).setOnClickListener(this);
        mRootView.findViewById(R.id.demo3_btn3).setOnClickListener(this);
        mTimeText = (TextView) mRootView.findViewById(R.id.demo3_timer);
        mTarget = (TextView) mRootView.findViewById(R.id.demo3_result);

        // ready
        final Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.scale1);
        animation.setFillEnabled(true);
        new CountDownTimer(6100, 1000) {

            @Override
            public void onTick(long l) {
                mTimeText.setText("" + (l/1000 - 1));
                mTimeText.startAnimation(animation);
            }

            @Override
            public void onFinish() {
                mTimeText.setText("");
                startTimer(true);

            }
        }.start();


        return mRootView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.demo3_btn1:
                break;
            case R.id.demo3_btn2:
                break;
            case R.id.demo3_btn3:
                break;
        }
    }
}
