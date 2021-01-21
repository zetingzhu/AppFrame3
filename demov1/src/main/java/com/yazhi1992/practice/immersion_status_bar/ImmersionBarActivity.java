package com.yazhi1992.practice.immersion_status_bar;


import com.zzt.demov1.R;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import com.zzt.demov1.R;

public class ImmersionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_immersion_bar);

        StatusBarUtils.with(this)
                .setColor(getResources().getColor(R.color.blue))
//                .setDrawable(getResources().getDrawable(R.drawable.shape))
                .init();
    }
}
