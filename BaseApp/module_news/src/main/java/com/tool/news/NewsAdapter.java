package com.tool.news;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class NewsAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private ArrayList<String> mList = new ArrayList<>();

    public NewsAdapter(FragmentManager fm,Context context,ArrayList<String> list) {
        super(fm);
        this.mContext = context;
        this.mList.clear();
        this.mList.addAll(list);
    }

    @Override
    public Fragment getItem(int i) {
//        switch (i){
//            case 0:
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//        }
        return NewsFragment.getIntance();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return this.mList.size();
    }
}
