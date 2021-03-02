package com.zzt.floatlayoutsample;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.zzt.adapter.StartActivityRecyclerAdapter;
import com.zzt.entity.StartActivityDao;
import com.zzt.utils.SizeUtils;

import java.util.ArrayList;
import java.util.List;

public class FloatLayoutActivity extends AppCompatActivity {
    private static final String TAG = FloatLayoutActivity.class.getSimpleName();
    RecyclerView recyclerview;
    QMUIFloatLayout mFloatLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_layout);
        recyclerview = findViewById(R.id.recyclerview);
        mFloatLayout = findViewById(R.id.qmuidemo_floatlayout);
        List<StartActivityDao> mList = new ArrayList<>();
        mList.add(new StartActivityDao("增加一个item", "", ""));
        mList.add(new StartActivityDao("减少一个item", "", ""));
        mList.add(new StartActivityDao("居左", "", ""));
        mList.add(new StartActivityDao("居中", "", ""));
        mList.add(new StartActivityDao("居右", "", ""));
        mList.add(new StartActivityDao("限制最多显示1行", "", ""));
        mList.add(new StartActivityDao("限制最多显示4个item", "", ""));
        mList.add(new StartActivityDao("不限制行数或个数", "", ""));
        StartActivityRecyclerAdapter.setAdapterData(recyclerview, LinearLayout.HORIZONTAL, mList, new StartActivityRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                onItem(position);
            }
        });

        for (int i = 0; i < 8; i++) {
            addItemToFloatLayout(mFloatLayout);
        }
        mFloatLayout.setOnLineCountChangeListener(new QMUIFloatLayout.OnLineCountChangeListener() {
            @Override
            public void onChange(int oldLineCount, int newLineCount) {
                Log.i(TAG, "oldLineCount = " + oldLineCount + " ;newLineCount = " + newLineCount);
            }
        });
    }

    public void onItem(int position) {
        switch (position) {
            case 0:
                addItemToFloatLayout(mFloatLayout);
                break;
            case 1:
                removeItemFromFloatLayout(mFloatLayout);
                break;
            case 2:
                mFloatLayout.setGravity(Gravity.LEFT);
                break;
            case 3:
                mFloatLayout.setGravity(Gravity.CENTER_HORIZONTAL);
                break;
            case 4:
                mFloatLayout.setGravity(Gravity.RIGHT);
                break;
            case 5:
                mFloatLayout.setMaxLines(1);
                break;
            case 6:
                mFloatLayout.setMaxNumber(4);
                break;
            case 7:
                mFloatLayout.setMaxLines(Integer.MAX_VALUE);
                break;
            default:
                break;
        }
    }

    private void addItemToFloatLayout(QMUIFloatLayout floatLayout) {
        int currentChildCount = floatLayout.getChildCount();

        TextView textView = new TextView(FloatLayoutActivity.this);
        int textViewPadding = SizeUtils.dp2px(4);
        textView.setPadding(textViewPadding, textViewPadding, 0, 0);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        textView.setTextColor(ContextCompat.getColor(FloatLayoutActivity.this, R.color.qmui_config_color_white));
        textView.setText(String.valueOf(currentChildCount));
        textView.setBackgroundResource(currentChildCount % 2 == 0 ? R.color.app_color_theme_3 : R.color.app_color_theme_6);

        int width = (int) (Math.random() * 300 + SizeUtils.dp2px(20));
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(width, SizeUtils.dp2px(60));
        floatLayout.addView(textView, lp);
    }

    private void removeItemFromFloatLayout(QMUIFloatLayout floatLayout) {
        if (floatLayout.getChildCount() == 0) {
            return;
        }
        floatLayout.removeView(floatLayout.getChildAt(floatLayout.getChildCount() - 1));
    }
}