package cn.yj.audioandvideolearn.learn3;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.yj.audioandvideolearn.util.T;

/**
 * Created by yangjie on 2019/1/10.
 */

public class AudioTracker {
    private final static int AUDIO_STREAM_TYPE = AudioManager.STREAM_MUSIC;
    // AudioTrack.MODE_STATIC 一次性输出，AudioTrack.MODE_STREAM 持续输出
    private final static int AUDIO_STREAM_MODE = AudioTrack.MODE_STATIC;
    //采用频率
    //44100是目前的标准，但是某些设备仍然支持22050，16000，11025
    //采样频率一般共分为22.05KHz、44.1KHz、48KHz三个等级
    private final static int AUDIO_SAMPLE_RATE = 16000;
    //输出声道 单声道
    private final static int AUDIO_CHANNEL = AudioFormat.CHANNEL_OUT_MONO;
    //编码
    private final static int AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;

    private String filePath;
    private File file;
    // 是否存在该文件
    private boolean isExistFile;
    private byte[] audioData;
    private AudioTrack audioTrack;

    public AudioTracker(String filePath) {
        this.filePath = filePath;
    }

    // 会引发内存泄露，仅做demo演示流程
    // 实际项目应用上可以用线程池+handler来处理
    public void play() {
         new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                file = new File(filePath);
                isExistFile = file.exists();
                if (!isExistFile) {
                    T.show("没找到文件");
                }
            }

            @Override
            protected Void doInBackground(Void... voids) {
                if (!isExistFile) {
                    return  null;
                }

                try {
                    InputStream in = new FileInputStream(file);
                    try {
                        ByteArrayOutputStream out = new ByteArrayOutputStream(
                                264848);
                        byte[] bytes = new byte[1024];
                        for (;(in.read(bytes)) != -1;) {
                            out.write(bytes);
                        }
                        audioData = out.toByteArray();
                    } finally {
                        in.close();
                    }
                } catch (IOException e) {
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (!isExistFile) {
                    return ;
                }
                audioTrack = new AudioTrack(AUDIO_STREAM_TYPE, AUDIO_SAMPLE_RATE, AUDIO_CHANNEL, AUDIO_ENCODING, audioData.length, AUDIO_STREAM_MODE);
                audioTrack.write(audioData, 0, audioData.length);
                audioTrack.play();
            }
        }.execute();
    }


}
