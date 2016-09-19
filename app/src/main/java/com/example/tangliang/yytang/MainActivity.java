package com.example.tangliang.yytang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame_1);

        FrameLayout frame = (FrameLayout) findViewById(R.id.myLayout);
        final GirlView girl = new GirlView(MainActivity.this);

        //为我们的萌妹子添加触摸事件监听器
        girl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
               //设置妹子的显示位置
                girl.bitmapX = event.getX() - 150;
                girl.bitmapY = event.getY() - 150;
                //调用重绘方法
                girl.invalidate();
                return true;
            }
        });
        frame.addView(girl);
    }
}
