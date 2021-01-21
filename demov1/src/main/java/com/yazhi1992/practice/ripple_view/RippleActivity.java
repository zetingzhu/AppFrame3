package com.yazhi1992.practice.ripple_view;


import com.zzt.demov1.R;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.zzt.demov1.R;

public class RippleActivity extends AppCompatActivity {

    private RippleView mRippleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple);

        mRippleView = (RippleView) findViewById(R.id.rippleView);

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRippleView.star();
            }
        });
    }
}
