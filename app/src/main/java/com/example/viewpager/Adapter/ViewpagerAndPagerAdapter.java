package com.example.viewpager.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpager.MainActivity;
import com.example.viewpager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小新 on 2016/5/1.
 */
public class ViewpagerAndPagerAdapter extends PagerAdapter {
    private List<View> mViews = new ArrayList<View>();
    Context context;
    public ViewpagerAndPagerAdapter( Context context){
        this.context = context;
        LayoutInflater mInflater = LayoutInflater.from(context);
        View tab01 = mInflater.inflate(R.layout.tab01,null);
        View tab02 = mInflater.inflate(R.layout.tab02,null);
        View tab03 = mInflater.inflate(R.layout.tab03,null);
        View tab04 = mInflater.inflate(R.layout.tab04,null);
        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);
    }


    @Override //这个是父类的方法 实现加载页面
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViews.get(position);
        container.addView(view);
        return view;
    }

    @Override//这个是父类的方法 实现删除页面
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
