package com.example.ikeak.charactersynopsis;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;

    public ScreenSlidePagerAdapter(FragmentManager fm, List<Fragment> fragment) {
        super(fm);

        this.mFragmentList = fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }


    //The pageAdapter takes all the fragments and connects it to the viewpager
    //Viewpager uses the pageAdapter objects for new pages to display
}
