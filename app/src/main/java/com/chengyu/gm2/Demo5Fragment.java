package com.chengyu.gm2;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Demo5Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Demo5Fragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "Demo5Fragment";
    private View mRootView;
    private TableRow mRow1;
    private TableRow mRow2;
    private TableRow mRow3;
    private int mBTN1Count;
    private int mBTN2Count;
    private int mBTN3Count;
    private boolean mCompleted = false;
    private TextView mCompletedMsg;

    public Demo5Fragment() {
        // Required empty public constructor
    }

    public static Demo5Fragment newInstance(Bundle args) {
        Demo5Fragment fragment = new Demo5Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_demo5, container, false);
        mCompletedMsg = (TextView) mRootView.findViewById(R.id.demo5_completed_msg);
        mRow1 = (TableRow) mRootView.findViewById(R.id.demo5_row1);
        mRow2 = (TableRow) mRootView.findViewById(R.id.demo5_row2);
        mRow3 = (TableRow) mRootView.findViewById(R.id.demo5_row3);

        mRootView.findViewById(R.id.demo5_btn1).setOnClickListener(this);
        mRootView.findViewById(R.id.demo5_btn2).setOnClickListener(this);
        mRootView.findViewById(R.id.demo5_btn3).setOnClickListener(this);

        // prepare question
        mBTN1Count = 0;
        mBTN2Count = 0;
        mBTN3Count = 0;
        prepareQuestion(mRow1);
        Log.d(TAG, "btn1 count:" + mBTN1Count);
        prepareQuestion(mRow2);
        Log.d(TAG, "btn2 count:" + mBTN2Count);
        prepareQuestion(mRow3);
        Log.d(TAG, "tn3 count" + mBTN3Count);


        return mRootView;
    }

    private void prepareQuestion(TableRow tableRow) {
        int viewCount = (int) (Math.random()*5);
        int color = Color.BLACK;
        switch (tableRow.getId()) {
            case R.id.demo5_row1:
                mBTN1Count = viewCount;
                color = Color.RED;
                break;
            case R.id.demo5_row2:
                mBTN2Count = viewCount;
                color = Color.GREEN;
                break;
            case R.id.demo5_row3:
                mBTN3Count = viewCount;
                color = Color.BLUE;
                break;
        }
        for (int i=0; i<viewCount; i++) {
            View view = createChildView(color);
            tableRow.addView(view);
        }
    }

    @NonNull
    private View createChildView(int color) {
        View view = new View(getActivity());
        TableRow.LayoutParams lp = new TableRow.LayoutParams(100, 100);
        lp.setMargins(10, 0, 10, 0);
        view.setLayoutParams(lp);
        view.setBackgroundColor(color);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (mCompleted) {
            return;
        }
        switch (view.getId()) {
            case R.id.demo5_btn1:
                if (mBTN1Count > 0) {
                    mBTN1Count--;
                    mRow1.removeViewAt(0);
                } else {
                    if (mRow1.getChildCount() < 5) {
                        View child = createChildView(Color.RED);
                        mRow1.addView(child);
                        mBTN1Count++;
                    }

                }
                break;
            case R.id.demo5_btn2:
                if (mBTN2Count > 0) {
                    mBTN2Count--;
                    mRow2.removeViewAt(0);
                } else {
                    if (mRow2.getChildCount() < 5) {
                        View child = createChildView(Color.GREEN);
                        mRow2.addView(child);
                        mBTN2Count++;
                    }

                }
                break;
            case R.id.demo5_btn3:
                if (mBTN3Count > 0) {
                    mBTN3Count--;
                    mRow3.removeViewAt(0);
                } else {
                    if (mRow3.getChildCount() < 5) {
                        View child = createChildView(Color.BLUE);
                        mRow3.addView(child);
                        mBTN3Count++;
                    }

                }
                break;
        }
        if (mBTN1Count + mBTN2Count + mBTN3Count == 0) {
            mCompleted = true;
            mCompletedMsg.setVisibility(View.VISIBLE);
        }
    }
}
