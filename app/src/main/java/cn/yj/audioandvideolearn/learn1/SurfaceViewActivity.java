package cn.yj.audioandvideolearn.learn1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.yj.audioandvideolearn.R;
import cn.yj.audioandvideolearn.learn1.view.MySurfaceView;

/**
 * Created by yangjie on 2019/1/5.
 */

public class SurfaceViewActivity extends Activity {

    @BindView(R.id.sv)
    MySurfaceView sv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);
        ButterKnife.bind(this);

        // SurfaceView要实现CallBack、Runable接口
        // 在内部开启1个子线程，循环调用draw方法
        // 在view销毁时，改变标志位，停止draw
    }
}
