package com.example.poject1.adapter;

import android.content.Context;

import com.example.poject1.fragment.FirstFragment;
import com.example.poject1.fragment.FourthFragment;
import com.example.poject1.fragment.SecondFragment;
import com.example.poject1.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    private static final int FRAGMENT_COUNT = 4;
    private List<String> mTitles;


    public FragmentAdapter(@NonNull FragmentManager fm, Context context) {

        super(fm);
        initTitles(context);
    }

    private void initTitles(Context context) {
        mTitles = new ArrayList<>();
        mTitles.add("Tab1");
        mTitles.add("Tab2");
        mTitles.add("Tab3");
        mTitles.add("Tab4");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return FirstFragment.newInstance();
            case 1:
                return SecondFragment.newInstance();
            case 2:
                return ThirdFragment.newInstance();
            case 3:
                return FourthFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
