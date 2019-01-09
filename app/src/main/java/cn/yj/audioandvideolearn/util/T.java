package cn.yj.audioandvideolearn.util;

import android.widget.Toast;

import cn.yj.audioandvideolearn.APP;

/**
 * Created by yangjie on 2019/1/5.
 */

public class T {
    public static void show(String str) {
        Toast.makeText(APP.getApp(), str, Toast.LENGTH_SHORT).show();
    }
}
