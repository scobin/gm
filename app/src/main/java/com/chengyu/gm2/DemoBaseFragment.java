package com.chengyu.gm2;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by chengyu on 2016/12/27.
 */
public abstract class DemoBaseFragment extends Fragment {
    protected ViewGroup mRootView;
    protected int mCount;
    protected Handler mHandler = new Handler();
    protected Timer mTimer;
    private CountUpTimerTask mTimerTask = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    protected void stopTimer() {
        if (null != mTimer) {
            mTimer.cancel();
            mTimer = null;

        }
    }

    protected void startTimer(boolean isNeededClear) {
        stopTimer();
        mTimer = new Timer();
        mTimerTask = new CountUpTimerTask();

        mTimer.schedule(mTimerTask, 0, 10);

        if (isNeededClear) {
            mCount = 0;
        }


    }

    class CountUpTimerTask extends TimerTask {

        @Override
        public void run() {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCount++;

                    updateUI();
                }
            });
        }
    }

    protected abstract void updateUI();
}
