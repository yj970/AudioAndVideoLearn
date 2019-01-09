package cn.yj.audioandvideolearn.learn1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.yj.audioandvideolearn.R;
import cn.yj.audioandvideolearn.util.L;
import cn.yj.audioandvideolearn.util.T;

/**
 * Created by yangjie on 2019/1/5.
 */

public class ImageViewActivity extends Activity {

    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_image_view);
        ButterKnife.bind(this);

        // 用imageview加载手机存储中的图片
        String path = "/mnt/shared/Image/1.jpg";
        L.d(path);
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        if (bitmap == null) {
            T.show("找不到名字为1.jpg的文件");
        } else {
            iv.setImageBitmap(bitmap);
        }

    }
}
