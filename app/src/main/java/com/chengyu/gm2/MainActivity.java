package com.chengyu.gm2;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        Demo2 demo2 = DemoBaseFragment.newInstance(null);

        Demo4Fragment fragment = Demo4Fragment.newInstance(null);
        ft.add(R.id.main_frame, fragment, fragment.TAG);
        ft.commit();
    }
}
