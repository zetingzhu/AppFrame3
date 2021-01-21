package com.yazhi1992.practice.hook_icon;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zzt.demov1.R;

/**
 * 仿支付宝支付成功打钩动画
 */
public class HookIconActivity extends AppCompatActivity {

    private HookIcon mHookIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook_icon);

        mHookIcon = (HookIcon) findViewById(R.id.hookIcon);

        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHookIcon.startAnim();
            }
        });
    }
}
