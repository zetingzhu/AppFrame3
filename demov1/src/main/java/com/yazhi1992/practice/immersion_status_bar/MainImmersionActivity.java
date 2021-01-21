package com.yazhi1992.practice.immersion_status_bar;

import android.content.Intent;


import com.zzt.demov1.R;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.zzt.demov1.R;


public class MainImmersionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_immersion_status_bar);

        findViewById(R.id.immersion_img_btn).setOnClickListener(this);
        findViewById(R.id.immersion_normal_btn).setOnClickListener(this);
        findViewById(R.id.immersion_nav_btn).setOnClickListener(this);
        findViewById(R.id.immersion_actionbar_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.immersion_img_btn:
                startActivity(new Intent(this, ImmersionImageActivity.class));
                break;
            case R.id.immersion_normal_btn:
                startActivity(new Intent(this, ImmersionBarActivity.class));
                break;
            case R.id.immersion_nav_btn:
                startActivity(new Intent(this, ImmersionNavActivity.class));
                break;
            case R.id.immersion_actionbar_btn:
                startActivity(new Intent(this, ImmersionActionBarActivity.class));
                break;
            default:
                break;
        }
    }
}
