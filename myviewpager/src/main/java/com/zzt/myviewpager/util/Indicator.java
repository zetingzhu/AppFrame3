package com.zzt.myviewpager.util;

import android.view.View;

import androidx.annotation.NonNull;


public interface Indicator extends OnPageChangeListener {
    @NonNull
    View getIndicatorView();

    IndicatorConfig getIndicatorConfig();

    void onPageChanged(int count, int currentPosition);

}
