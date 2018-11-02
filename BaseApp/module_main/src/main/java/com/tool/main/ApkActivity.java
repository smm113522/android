package com.tool.main;

import com.speed.hotpatch.libs.SpeedHostBaseActivity;

public class ApkActivity extends SpeedHostBaseActivity {


    @Override
    public String getApkKeyName() {
        return MainActivity.FIRST_APK_KEY;
    }

    @Override
    public String getClassTag() {
        return null;
    }
}
