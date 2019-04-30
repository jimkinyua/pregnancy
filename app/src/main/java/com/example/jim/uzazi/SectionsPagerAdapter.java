package com.example.jim.uzazi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> pages = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public  void addpage(Fragment fragment){
        pages.add(fragment);

        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {

        return pages.get(position);

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return pages.size();

    }





}
