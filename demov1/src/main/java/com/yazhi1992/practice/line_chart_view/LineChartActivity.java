package com.yazhi1992.practice.line_chart_view;


import com.zzt.demov1.R;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.zzt.demov1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.value;

public class LineChartActivity extends AppCompatActivity {

    private LineChart mLineChart;
    //值
    private List<ValueBean> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        int time = 0;
        for (int i = 0; i < 20; i++) {
            mData.add(new ValueBean("" + time, (int) (1000 + Math.random() * 200)));
            time++;
        }

        mLineChart = (LineChart) findViewById(R.id.lineChartView);
        mLineChart.setValueList(mData);

    }
}
