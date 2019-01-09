package cn.yj.audioandvideolearn.learn1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import cn.yj.audioandvideolearn.util.L;
import cn.yj.audioandvideolearn.util.T;

/**
 * Created by yangjie on 2019/1/9.
 */

public class CustomerView extends View{
    Bitmap bitmap;
    Paint paint;
    public CustomerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();

        // 用imageview加载手机存储中的图片
        String path = "/mnt/shared/Image/1.jpg";
        L.d(path);
        bitmap = BitmapFactory.decodeFile(path);
        if (bitmap == null) {
            T.show("找不到名字为1.jpg的文件");
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0,0, paint);
        }
    }
}
