package cn.yj.audioandvideolearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.yj.audioandvideolearn.learn1.ViewsActivity;
import cn.yj.audioandvideolearn.learn2.AudioRecorderActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {
        startActivity(new Intent(this, ViewsActivity.class));
    }

    public void click2(View view) {
        startActivity(new Intent(this, AudioRecorderActivity.class));
    }
}
