package com.zzt.mylibrary2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zeting
 * @date: 2020/12/24
 * 列表测试数据跳转
 */
public class StartListView extends ListView {
    private List<DemoInfo> DEMOS = new ArrayList<>();
    private DemoListAdapter demoListAdapter;

    public StartListView(Context context) {
        super(context);
        initView();
    }

    public StartListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public StartListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        // 添加ListItem，设置事件响应
        setAdapter(demoListAdapter = new DemoListAdapter());
        setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int index, long arg3) {
                onListItemClick(index);
            }
        });
//        ColorDrawable sage = new ColorDrawable(this.getResources().getColor(android.R.color.black));
        ColorDrawable sage = new ColorDrawable(Color.parseColor("#ABBAFB"));
        setDivider(sage);
        setDividerHeight(1);
    }

    public void setDemos(DemoInfo[] str) {
        setDemos(Arrays.asList(str));
    }

    public void setDemos(List<DemoInfo> list) {
        this.DEMOS = list;
        if (demoListAdapter != null) {
            demoListAdapter.notifyDataSetChanged();
        }
    }


    void onListItemClick(int index) {
        Intent intent;
        intent = new Intent(getContext(), DEMOS.get(index).demoClass);
        getContext().startActivity(intent);
    }

    public class DemoListAdapter extends BaseAdapter {
        @Override
        public View getView(int index, View convertView, ViewGroup parent) {
            MyViewHolder myViewHolder;
            LinearLayout linearLayout = (LinearLayout) convertView;
            if (convertView == null) {
                linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setPadding(20, 10, 20, 10);

                TextView textTitle = new TextView(getContext());
                textTitle.setTextSize(18);
                textTitle.setTextColor(Color.parseColor("#000000"));
                linearLayout.addView(textTitle);

                TextView textDesc = new TextView(getContext());
                textDesc.setTextSize(12);
                textDesc.setTextColor(Color.parseColor("#000000"));
                linearLayout.addView(textDesc);

                myViewHolder = new MyViewHolder(linearLayout, textTitle, textDesc);
                linearLayout.setTag(myViewHolder);
            } else {
                myViewHolder = (MyViewHolder) convertView.getTag();
            }
            myViewHolder.title.setText(DEMOS.get(index).title);
            myViewHolder.desc.setText(DEMOS.get(index).desc);
            if (index >= 25) {
                myViewHolder.title.setTextColor(Color.YELLOW);
            }
            return linearLayout;
        }

        @Override
        public int getCount() {
            return DEMOS.size();
        }

        @Override
        public Object getItem(int index) {
            return DEMOS.get(index);
        }

        @Override
        public long getItemId(int id) {
            return id;
        }


        class MyViewHolder {
            TextView title;
            TextView desc;

            public MyViewHolder(LinearLayout linearLayout, TextView textTitle, TextView textDesc) {
                this.title = textTitle;
                this.desc = textDesc;
            }
        }
    }

    public class DemoInfo {
        public String title = "";
        public String desc = "";
        public Class<? extends Activity> demoClass;
        public String arouter;// 路由地址

        public DemoInfo(String title, String desc, String arouter) {
            this.title = title;
            this.desc = desc;
            this.arouter = arouter;
        }

        public DemoInfo(String title, String desc,
                        Class<? extends Activity> demoClass) {
            this.title = title;
            this.desc = desc;
            this.demoClass = demoClass;
        }


    }
}
