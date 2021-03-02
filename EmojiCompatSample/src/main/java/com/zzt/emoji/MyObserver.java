package com.zzt.emoji;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * @author: zeting
 * @date: 2021/2/5
 */
public class MyObserver implements DefaultLifecycleObserver {
    public final String TAG = MyObserver.class.getSimpleName();

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.e(TAG, " MyObserver -- onCreate");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Log.e(TAG, " MyObserver -- onStart");

    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        Log.e(TAG, " MyObserver -- onResume");

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Log.e(TAG, " MyObserver -- onPause");

    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Log.e(TAG, " MyObserver -- onStop");

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Log.e(TAG, " MyObserver -- onDestroy");

    }
}
