package com.xbw.arukas;

import android.app.Application;
import com.umeng.commonsdk.UMConfigure;

public class CommonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //设置LOG开关，默认为false
        UMConfigure.setLogEnabled(true);
        //初始化组件化基础库, 统计SDK/推送SDK/分享SDK都必须调用此初始化接口 
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, null);
    }
}
