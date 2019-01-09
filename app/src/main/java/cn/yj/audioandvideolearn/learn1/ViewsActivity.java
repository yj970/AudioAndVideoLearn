package cn.yj.audioandvideolearn.learn1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.yj.audioandvideolearn.R;

/**
 * Created by yangjie on 2019/1/5.
 */

public class ViewsActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
    }

    public void click1(View view) {
        startActivity(new Intent(this, ImageViewActivity.class));

    }

    public void click2(View view) {
        startActivity(new Intent(this, SurfaceViewActivity.class));
    }

    public void click3(View view) {
        startActivity(new Intent(this, CustomerViewActivity.class));
    }
}
