package com.hwd.chuichuishuidianuser.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hwd.chuichuishuidianuser.R;
import com.hwd.chuichuishuidianuser.adapter.MainFragmentPagerAdapter;
import com.hwd.chuichuishuidianuser.view.IndexViewpager;

import butterknife.BindView;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

//    @BindView(R.id.yg_tab_bar)
    RadioGroup yg_tab_bar;
   // @BindView(R.id.yg_channel)
    RadioButton yg_channel;
    @BindView(R.id.first)
    RadioButton first;
    @BindView(R.id.yg_message)
    RadioButton yg_message;
    @BindView(R.id.yg_better_2)
    RadioButton yg_better_2;
//    @BindView(R.id.yg_vpager)
    IndexViewpager yg_vpager;

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
   private MainFragmentPagerAdapter mAdapter;

    String strRand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentStatus | flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }

        findView();
        yg_tab_bar.setOnCheckedChangeListener(this);
        mAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
        yg_vpager.setAdapter(mAdapter);
        first.setChecked(true);
    }

    private void findView()
    {
        yg_tab_bar =findViewById(R.id.yg_tab_bar);
        yg_vpager =findViewById(R.id.yg_vpager);
        yg_channel =findViewById(R.id.yg_channel);
        first =findViewById(R.id.first);
        yg_message =findViewById(R.id.yg_message);
        yg_better_2 =findViewById(R.id.yg_better_2);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        ClearColor();
        switch (i) {
            case R.id.yg_channel:
                yg_vpager.setCurrentItem(PAGE_TWO);
                yg_channel.setTextColor(Color.parseColor("#29b4fc"));
                break;
            case R.id.first:
                yg_vpager.setCurrentItem(PAGE_ONE);
                first.setTextColor(Color.parseColor("#29b4fc"));
                break;
            case R.id.yg_message:
                yg_vpager.setCurrentItem(PAGE_THREE);
                yg_message.setTextColor(Color.parseColor("#29b4fc"));
                break;
            case R.id.yg_better_2:
                yg_vpager.setCurrentItem(PAGE_FOUR);
                yg_better_2.setTextColor(Color.parseColor("#29b4fc"));
                break;
        }
    }

    private void ClearColor()
    {
        yg_channel.setTextColor(Color.parseColor("#757575"));
        yg_message.setTextColor(Color.parseColor("#757575"));
        first.setTextColor(Color.parseColor("#757575"));
        yg_better_2.setTextColor(Color.parseColor("#757575"));
    }
}
