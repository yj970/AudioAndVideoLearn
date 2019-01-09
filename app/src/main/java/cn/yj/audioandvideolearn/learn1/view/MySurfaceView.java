package cn.yj.audioandvideolearn.learn1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import cn.yj.audioandvideolearn.util.L;
import cn.yj.audioandvideolearn.util.T;

/**
 * Created by yangjie on 2019/1/5.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable{
    SurfaceHolder mSurfaceHolder;
    // 画布
    private Canvas mCanvas;
    // 子线程标志位
    private boolean isDrawing;

    private Bitmap mBitmap;

    private Paint paint;

    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mSurfaceHolder = getHolder();//得到SurfaceHolder对象
        mSurfaceHolder.addCallback(this);//注册SurfaceHolder
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);//保持屏幕长亮

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

        String path = "/mnt/shared/Image/1.jpg";
        L.d(path);
        mBitmap= BitmapFactory.decodeFile(path);
        if (mBitmap == null) {
            T.show("找不到名字为1.jpg的文件");
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawing = false;
    }

    @Override
    public void run() {
        while (isDrawing && mBitmap != null){
            drawing();
        }
    }

    private void drawing() {
        try {
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawBitmap(mBitmap, 0, 0, paint);// 执行绘制操作
        }finally {
            if (mCanvas != null){
                mSurfaceHolder.unlockCanvasAndPost(mCanvas);
            }
        }

    }
}
