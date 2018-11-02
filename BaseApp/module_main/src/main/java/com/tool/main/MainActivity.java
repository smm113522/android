package com.tool.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.speed.hotpatch.libs.SpeedApkManager;
import com.speed.hotpatch.libs.SpeedUtils;
import com.tool.common.base.BaseActivity;
import com.tool.common.base.BaseQuickAdapter;
import com.tool.common.base.BaseViewHolder;
import com.tool.common.uitls.AppToastMgr;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    public static final String FIRST_APK_KEY="first_apk";

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
        list.add("音乐");
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
                        SpeedUtils.goActivity(getActivity(), FIRST_APK_KEY, null);
                        break;
                    case 2:
                        ARouter.getInstance().build("/news/activity").navigation();
                        break;
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = "module_music-debug.apk";
                String dexOutPath="dex_output2";
                File nativeApkPath = SpeedUtils.getNativeApkPath(getApplicationContext(), s);
                if (nativeApkPath != null) {
                    SpeedApkManager.getInstance().loadApk(FIRST_APK_KEY, nativeApkPath.getAbsolutePath(), dexOutPath, getActivity());
                }

            }
        }).start();

    }

}
