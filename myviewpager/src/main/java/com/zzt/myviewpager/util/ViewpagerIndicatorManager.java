package com.zzt.myviewpager.util;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/**
 * Viewpager2 和 indicator 管理器
 */
public class ViewpagerIndicatorManager {
    public static final int INVALID_VALUE = -1;
    ViewPager2 mViewPager2;
    CircleIndicator mIndicator;
    @Nullable
    private RecyclerView.Adapter<?> mAdapter;

    private BannerOnPageChangeCallback mPageChangeCallback;

    public ViewpagerIndicatorManager(ViewPager2 viewPager2, CircleIndicator indicator) {
        this.mViewPager2 = viewPager2;
        this.mIndicator = indicator;
    }

    public void attach() {
        mAdapter = mViewPager2.getAdapter();
        if (mAdapter == null) {
            throw new IllegalStateException(
                    "attached before ViewPager2 has an " + "adapter");
        }
        mPageChangeCallback = new BannerOnPageChangeCallback();
        mViewPager2.registerOnPageChangeCallback(mPageChangeCallback);
        setIndicatorPageChange();
    }

    public Indicator getIndicator() {
        return mIndicator;
    }

    public ViewPager2 getViewPager2() {
        return mViewPager2;
    }

    public int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public RecyclerView.Adapter<?> getAdapter() {
        return mAdapter;
    }

    public int getRealCount() {
        if (getAdapter() != null) {
            return getAdapter().getItemCount();
        }
        return 0;

    }

    public void setIndicatorPageChange() {
        if (getIndicator() != null) {
            getIndicator().onPageChanged(getRealCount(), 0);
        }
    }

    class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private int mTempPosition = INVALID_VALUE;
        private boolean isScrolled;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (getIndicator() != null && position == getCurrentItem() - 1) {
                getIndicator().onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
            if (isScrolled) {
                if (getIndicator() != null) {
                    getIndicator().onPageSelected(position);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            //手势滑动中,代码执行滑动中
            if (state == ViewPager2.SCROLL_STATE_DRAGGING || state == ViewPager2.SCROLL_STATE_SETTLING) {
                isScrolled = true;
            } else if (state == ViewPager2.SCROLL_STATE_IDLE) {
                //滑动闲置或滑动结束
                isScrolled = false;
            }

            if (getIndicator() != null) {
                getIndicator().onPageScrollStateChanged(state);
            }
        }

    }


}
