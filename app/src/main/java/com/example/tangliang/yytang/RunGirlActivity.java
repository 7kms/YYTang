package com.example.tangliang.yytang;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.Timer;
import java.util.TimerTask;

public class RunGirlActivity extends AppCompatActivity {
    //初始化变量,帧布局
    FrameLayout frame = null;
    //自定义一个用于定时更新UI界面的handler类对象
    Handler handler = new Handler(){
        int i=0;
        @Override
        public void handleMessage(Message msg) {
            // 判断信息是否为本应用发出的
            if(msg.what == 0x123){
                i++;
                move(i%8);
            }
            super.handleMessage(msg);
        }
    };
    private void move(int i) {
        Drawable a = getResources().getDrawable(R.mipmap.s_1);
        Drawable b = getResources().getDrawable(R.mipmap.s_2);
        Drawable c = getResources().getDrawable(R.mipmap.s_3);
        Drawable d = getResources().getDrawable(R.mipmap.s_4);
        Drawable e = getResources().getDrawable(R.mipmap.s_5);
        Drawable f = getResources().getDrawable(R.mipmap.s_6);
        Drawable g = getResources().getDrawable(R.mipmap.s_7);
        Drawable h = getResources().getDrawable(R.mipmap.s_8);

        switch (i){
            case 1:
                frame.setForeground(a);
                break;
            case 2:
                frame.setForeground(b);
                break;
            case 3:
                frame.setForeground(c);
                break;
            case 4:
                frame.setForeground(d);
                break;
            case 5:
                frame.setForeground(e);
                break;
            case 6:
                frame.setForeground(f);
                break;
            case 7:
                frame.setForeground(g);
                break;
            case 8:
                frame.setForeground(h);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame_2);
        frame = (FrameLayout) findViewById(R.id.runGirlFrame);
        //定义一个定时器对象,定时发送信息给handler
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },10,170);
    }
}
