package com.tool.news;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tool.common.base.BaseActivity;

@Route(path = "/news/activity")
public class NewsActivity extends BaseActivity {



    @Override
    public int getLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    public void initView() {

    }
}
