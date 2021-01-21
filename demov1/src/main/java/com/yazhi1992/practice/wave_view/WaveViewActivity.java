package com.yazhi1992.practice.wave_view;


import com.zzt.demov1.R;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.zzt.demov1.R;

public class WaveViewActivity extends AppCompatActivity {

    private SinWave mWave;
    private BezierWave mBezierWave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_view);

        mWave = (SinWave) findViewById(R.id.waveView);
        mBezierWave = (BezierWave) findViewById(R.id.bezierWave);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWave.start();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBezierWave.start();
            }
        });
    }
}
