package cn.yj.audioandvideolearn;

import android.app.Application;

/**
 * Created by yangjie on 2019/1/5.
 */

public class APP extends Application{
    public static APP app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static APP getApp() {
        return  app;
    }
}
