package com.jonli.regioncode;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jonli.regioncode.view.CodeFragment;
import com.jonli.regioncode.view.RegionFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    public static final int COUNT_FRAGMENT = 2;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CodeFragment();
            case 1:
                return new RegionFragment();
            default:
                break;
        }

        return null;
    }

    @Override
    public int getCount() {
        return COUNT_FRAGMENT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Поиск по коду";
            case 1:
                return "Поиск по региону";
            default:
                break;
        }
        return null;
    }
}
