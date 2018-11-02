package com.tool.music;

import android.app.Activity;
import android.os.Bundle;

import com.speed.hotpatch.libs.SpeedBaseInterfaceImp;

public class TestClass extends SpeedBaseInterfaceImp {

    private Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState, final Activity activity) {
        this.activity = activity;
        activity.setContentView(R.layout.activity_client_main);


    }
}
