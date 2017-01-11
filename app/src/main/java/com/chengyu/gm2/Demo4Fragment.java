package com.chengyu.gm2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chengyu on 2016/12/28.
 */

public class Demo4Fragment extends DemoBaseFragment implements View.OnClickListener {
    private View mTarget1;
    public String TAG = "Demo4Fragment";
    private ObjectAnimator mAnimator1;
    private Handler mHandler = new Handler();
    private View mCapture1;
    private int mScore;
    private View mTarget2;
    private View mTarget3;
    private View mCapture2;
    private View mCapture3;
    private TextView mScoreText;
    private ObjectAnimator mAnimator2;
    private ObjectAnimator mAnimator3;

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
        mScore = 0;
        mRootView = inflater.inflate(R.layout.fragment_demo4, container, false);
        mRootView.findViewById(R.id.demo4_btn1).setOnClickListener(this);
        mRootView.findViewById(R.id.demo4_btn2).setOnClickListener(this);
        mRootView.findViewById(R.id.demo4_btn3).setOnClickListener(this);

        mTarget1 = mRootView.findViewById(R.id.demo4_target1);
        mTarget2 = mRootView.findViewById(R.id.demo4_target2);
        mTarget3 = mRootView.findViewById(R.id.demo4_target3);
        mCapture1 = mRootView.findViewById(R.id.demo4_capture1);
        mCapture2 = mRootView.findViewById(R.id.demo4_capture2);
        mCapture3 = mRootView.findViewById(R.id.demo4_capture3);
        mScoreText = (TextView) mRootView.findViewById(R.id.demo4_score);

        mAnimator1 = ObjectAnimator.ofFloat(mTarget1, "translationY", 0, 1500);
        mAnimator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                mTarget1.setY(0);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                mTarget1.setY(0);
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        mAnimator2 = ObjectAnimator.ofFloat(mTarget2, "translationY", 0, 1500);
        mAnimator2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                mTarget2.setY(0);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                mTarget2.setY(0);
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        mAnimator3 = ObjectAnimator.ofFloat(mTarget3, "translationY", 0, 1500);
        mAnimator3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                mTarget3.setY(0);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                mTarget3.setY(0);
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        new CountDownTimer(10000, 500) {

            @Override
            public void onTick(long l) {
                int duration = (int)(Math.random() * 2000) + 500;
                int rand = (int) Math.floor(Math.random() * 3);
                if (rand == 0 && !mAnimator1.isRunning()) {
                    Log.d(TAG, "rand:" + rand);
                    mAnimator1.setDuration(duration);
                    mAnimator1.start();
                } else if (rand == 1 && !mAnimator2.isRunning()) {
                    Log.d(TAG, "rand:" + rand);
                    mAnimator2.setDuration(duration);
                    mAnimator2.start();
                } else if (rand == 2 && !mAnimator3.isRunning()) {
                    Log.d(TAG, "rand:" + rand);
                    mAnimator3.setDuration(duration);
                    mAnimator3.start();
                }

            }

            @Override
            public void onFinish() {
            }
        }.start();

        mScoreText.setText("" + mScore);
        return mRootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.demo4_btn1:
                if (checkCollision(mCapture1, view)) {
                    mAnimator1.cancel();
                    mScore++;
                    Log.d(TAG, "got it");
                }
                break;
            case R.id.demo4_btn2:
                if (checkCollision(mCapture2, view)) {
                    mAnimator2.cancel();
                    mScore++;
                    Log.d(TAG, "got it");
                }
                break;
            case R.id.demo4_btn3:
                if (checkCollision(mCapture3, view)) {
                    mAnimator3.cancel();
                    mScore++;
                    Log.d(TAG, "got it");
                }
                break;
        }
        mScoreText.setText("" + mScore);

    }

    public boolean checkCollision(View v1,View v2) {
        Rect R1=new Rect(v1.getLeft(), v1.getTop(), v1.getRight(), v1.getBottom());
        Rect R2=new Rect(v2.getLeft(), v2.getTop(), v2.getRight(), v2.getBottom());
        return R1.intersect(R2);
    }
}
