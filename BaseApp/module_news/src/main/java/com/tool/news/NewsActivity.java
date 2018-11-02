package com.tool.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tool.common.base.BaseActivity;

import java.util.ArrayList;

@Route(path = "/news/activity")
public class NewsActivity extends BaseActivity {

    private TabLayout mTablayout;
    private ViewPager mViewpager;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    public void initView() {
        mTablayout = (TabLayout) findViewById(R.id.tablayout);

//        mTablayout.addTab(mTablayout.newTab().setText("one"));
//        mTablayout.addTab(mTablayout.newTab().setText("two"));
//        mTablayout.addTab(mTablayout.newTab().setText("three"));

        ArrayList<String> list = new ArrayList<>();
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");

        adapter = new NewsAdapter(getSupportFragmentManager(), getActivity(), list);

        mViewpager = (ViewPager) findViewById(R.id.viewpager);

        mViewpager.setAdapter(adapter);

        mTablayout.setupWithViewPager(mViewpager, false);

    }
}
