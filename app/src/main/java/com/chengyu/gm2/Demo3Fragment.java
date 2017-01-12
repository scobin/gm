package com.chengyu.gm2;


import android.graphics.Color;
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
    private View mTarget;
    private TextView mTimeText;
    private TextView mResult;
    private int[] mColor = {Color.argb(255, 255, 0, 0), Color.argb(255, 0, 255, 0), Color.argb(255, 0, 0, 255)};
    private int mColorIndex;
    private int mClearCount = 0;
    private boolean mOver = false;

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
        mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_demo3, container, false);
        mRootView.findViewById(R.id.demo3_btn1).setOnClickListener(this);
        mRootView.findViewById(R.id.demo3_btn2).setOnClickListener(this);
        mRootView.findViewById(R.id.demo3_btn3).setOnClickListener(this);
        mTimeText = (TextView) mRootView.findViewById(R.id.demo3_timer);
        mResult = (TextView) mRootView.findViewById(R.id.demo3_result);
        mTarget = mRootView.findViewById(R.id.demo3_target);

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
                createColor();
            }
        }.start();


        return mRootView;
    }

    @Override
    public void onClick(View view) {
        if (mOver) {
            return;
        }
        switch(view.getId()) {
            case R.id.demo3_btn1:
                if (mColorIndex == 0) {
                    mResult.setText("Correct!");
                    createColor();
                    mClearCount++;
                } else {
                    mResult.setText("Incorrect!");
                }
                break;
            case R.id.demo3_btn2:
                if (mColorIndex == 1) {
                    mResult.setText("Correct!");
                    createColor();
                    mClearCount++;
                } else {
                    mResult.setText("Incorrect!");
                }
                break;
            case R.id.demo3_btn3:
                if (mColorIndex == 2) {
                    mResult.setText("Correct!");
                    createColor();
                    mClearCount++;
                } else {
                    mResult.setText("Incorrect!");
                }
                break;
        }
        if (mClearCount >= 10) {
            stopTimer();
            mOver = true;
        }

    }

    private void createColor() {
        mColorIndex = (int) (Math.random()*3);
        mTarget.setBackgroundColor(mColor[mColorIndex]);
    }
}
