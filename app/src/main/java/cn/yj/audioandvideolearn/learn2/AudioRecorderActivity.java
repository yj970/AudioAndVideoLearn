package cn.yj.audioandvideolearn.learn2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.yj.audioandvideolearn.R;

/**
 * Created by yangjie on 2019/1/9.
 */

public class AudioRecorderActivity extends Activity{
    AudioRecorder audioRecorder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_recorder);


        // 夜神模拟器不可用，真机可用，亲测（小米6）
        audioRecorder = new AudioRecorder();
        audioRecorder.createDefaultAudio("testAudio");
    }

    // 开始录音
    public void click1(View view) {
        audioRecorder.startRecord();
    }

    // 暂停录音
    public void click2(View view) {
        audioRecorder.pauseRecord();
    }

    // 停止录音
    public void click3(View view) {
        audioRecorder.stopRecord();
    }

    // 取消录音
    public void click4(View view) {
        audioRecorder.canel();
    }

}
