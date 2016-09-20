package com.example.tangliang.yytang;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UIEditText extends AppCompatActivity {
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiedit_text);
        /*EditText editText = (EditText) findViewById(R.id.editText2);
        editText.requestFocus();
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setSelectAllOnFocus(true);*/
        button = (Button) findViewById(R.id.testEditTextButton);
        editText = (EditText) findViewById(R.id.testEditText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString spanStr = new SpannableString("image");
                Drawable drawable = UIEditText.this.getResources().getDrawable(R.mipmap.ic_launcher);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                ImageSpan span = new ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
                spanStr.setSpan(span,0,4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                int cursor = editText.getSelectionStart();
                editText.getText().insert(cursor,spanStr);
            }
        });

    }
}
