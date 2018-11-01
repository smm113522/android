package com.tool.common.base;

import android.app.Application;

public class BaseApp extends Application{

    public static BaseApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static BaseApp getInstance(){
        return app;
    }

}
