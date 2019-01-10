package cn.yj.audioandvideolearn.learn3;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;

import cn.yj.audioandvideolearn.R;

/**
 * Created by yangjie on 2019/1/10.
 */

public class AudioTrackActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_track);
    }

    public void click1(View view) {
        String filePath = Environment.getExternalStorageDirectory().getPath()+"/testAudio/pcm/testAudio.pcm";
        AudioTracker audioTracker = new AudioTracker(filePath);
        audioTracker.play();
    }
}
