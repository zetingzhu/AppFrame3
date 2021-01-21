package com.yazhi1992.practice.rotate_circle;


import com.zzt.demov1.R;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.zzt.demov1.R;

public class RotateCircleActivity extends AppCompatActivity {

    private RotateCircleView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_circle);

        mView = (RotateCircleView) findViewById(R.id.rotateCircelView);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.star();
            }
        });
    }
}
