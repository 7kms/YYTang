package com.example.tangliang.yytang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UIButtonActivity extends AppCompatActivity {
    private Button btn1,btn2;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_uibutton);
                btn1 = (Button) findViewById(R.id.btnOne);
                btn2 = (Button) findViewById(R.id.btnTwo);
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(btn2.getText().toString().equals("按钮不可用")){
                            btn1.setEnabled(false);
                            btn2.setText("按钮可用");
                        }else {
                            btn1.setEnabled(true);
                            btn2.setText("按钮不可用");
                        }
                    }
        });
    }
}
