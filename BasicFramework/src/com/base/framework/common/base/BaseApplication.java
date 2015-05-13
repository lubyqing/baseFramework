package com.base.framework.common.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class BaseApplication extends Application {

    public static BaseApplication mApplication;

    public static Context mApplicationContext;

    public static BaseApplication getApplication() {
        return mApplication;
    }

    public static Context getAppContext() {
        return mApplicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;
        mApplicationContext = getApplicationContext();

        // 记录崩溃异常
        GlobalExceptionHandler ueHandler = new GlobalExceptionHandler(this);
        Thread.setDefaultUncaughtExceptionHandler(ueHandler);
    }

    @Override
    public void onLowMemory() {
    	Log.d("***", "memory_low");
    	super.onLowMemory();
    }

    
}
