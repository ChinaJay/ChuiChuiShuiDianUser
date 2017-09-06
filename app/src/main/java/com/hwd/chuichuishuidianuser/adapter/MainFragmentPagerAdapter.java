package com.hwd.chuichuishuidianuser.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hwd.chuichuishuidianuser.activity.MainActivity;
import com.hwd.chuichuishuidianuser.frament.HomePagerFrament;
import com.hwd.chuichuishuidianuser.frament.MineFrament;
import com.hwd.chuichuishuidianuser.frament.ShopCarFrament;
import com.hwd.chuichuishuidianuser.frament.ShopFrament;

/**
 * Created by Gary on 2016/12/15.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    private HomePagerFrament myFragment1 = null;
    private ShopFrament myFragment2 = null;
    private ShopCarFrament myFragment3 = null;
    private MineFrament myFragment4 = null;


    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new HomePagerFrament();
        myFragment2 = new ShopFrament();
        myFragment3 = new ShopCarFrament();
        myFragment4 = new MineFrament();

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = myFragment4;
                break;

        }
        return fragment;
    }




    @Override
    public int getCount() {
        return PAGER_COUNT;
    }



}