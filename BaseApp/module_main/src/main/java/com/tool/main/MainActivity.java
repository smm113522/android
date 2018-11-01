package com.tool.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tool.common.base.BaseActivity;
import com.tool.common.base.BaseQuickAdapter;
import com.tool.common.base.BaseViewHolder;
import com.tool.common.uitls.AppToastMgr;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerview;
    private BaseQuickAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        final ArrayList<String> list = new ArrayList<>();
        list.add("计划");
        list.add("测试");
        list.add("新闻");

        adapter = new BaseQuickAdapter<String, BaseViewHolder>(getActivity(), R.layout.item_main, list) {
            @Override
            protected void convert(BaseViewHolder holder, String item) {

                holder.setText(R.id.textView, item);

            }
        };

        mRecyclerview.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        AppToastMgr.shortToast(getApplicationContext(), list.get(position));
                        break;
                    case 1:
                        AppToastMgr.shortToast(getApplicationContext(), list.get(position));
                        break;
                    case 2:
                        ARouter.getInstance().build("/news/activity").navigation();
                        break;
                }
            }
        });


    }

}
