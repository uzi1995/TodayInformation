package com.example.todayinformation.main.hangzhou.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.todayinformation.main.hangzhou.view.JiKeFragment;
import com.example.todayinformation.main.hangzhou.view.RefreshFragment;
import com.example.todayinformation.main.hangzhou.view.ZhiHuFragment;

import java.util.ArrayList;

public class HangZhouViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> titleList = new ArrayList<>();


    public HangZhouViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        titleList.add("知乎");
        titleList.add("即刻");
        titleList.add("下拉刷新");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new ZhiHuFragment();
            case 1:
                return new JiKeFragment();
            case 2:
                return new RefreshFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titleList.get(position);
    }
}
