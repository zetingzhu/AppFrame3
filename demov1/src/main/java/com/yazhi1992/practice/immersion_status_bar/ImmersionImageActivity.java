package com.yazhi1992.practice.immersion_status_bar;


import com.zzt.demov1.R;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import com.zzt.demov1.R;

/**
 * 沉浸式图片
 */
public class ImmersionImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersion_image);

        StatusBarUtils.with(this)
                .init();
    }
}
