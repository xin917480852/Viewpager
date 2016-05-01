package com.example.viewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.viewpager.Adapter.ViewpagerAndPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    // TAB
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mWeixinImg;
    private ImageButton mFrdImg;
    private ImageButton mAddressImg;
    private ImageButton mSettingImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        // tabs
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);
        // ImageButton
        mWeixinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_settings_img);
        mAdapter = new ViewpagerAndPagerAdapter(MainActivity.this);
        mViewPager.setAdapter(mAdapter);
    }
    private void initEvents()
    {
        mTabWeixin.setOnClickListener(MainActivity.this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageSelected(int arg0)
            {
                int currentItem = mViewPager.getCurrentItem();
                resetImg();
                switch (currentItem)
                {
                    case 0:
                        mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        mAddressImg
                                .setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        mSettingImg
                                .setImageResource(R.drawable.tab_settings_pressed);
                        break;

                }

            }


            public void onPageScrolled(int arg0, float arg1, int arg2)
            {

            }
            public void onPageScrollStateChanged(int arg0)
            {

            }
        });
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId())
        {
            case R.id.id_tab_weixin:
                mViewPager.setCurrentItem(0);
                mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case R.id.id_tab_frd:
                mViewPager.setCurrentItem(1);
                mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                mViewPager.setCurrentItem(2);
                mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.id_tab_settings:
                mViewPager.setCurrentItem(3);
                mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
                break;

            default:
                break;
        }

    }
    private void resetImg()
    {
        mWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
        mFrdImg.setImageResource(R.drawable.tab_find_frd_normal);
        mAddressImg.setImageResource(R.drawable.tab_address_normal);
        mSettingImg.setImageResource(R.drawable.tab_settings_normal);
    }
}
