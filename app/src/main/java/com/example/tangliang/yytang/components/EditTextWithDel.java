package com.example.tangliang.yytang.components;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

import com.example.tangliang.yytang.R;

public class EditTextWithDel extends EditText{
    private final static String TAG = "EditTextWithDel";
    private Drawable imgInable;
    private Context context;
    public EditTextWithDel(Context context) {
        super(context);
        this.context = context;
        this.init();
    }
    public EditTextWithDel(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }
    public EditTextWithDel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }
    private void init(){
        imgInable = context.getResources().getDrawable(R.drawable.cancel);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                setDrawable();
            }
        });
        setDrawable();
    }
    //设置删除图片
    private void setDrawable(){
        if(length() < 1){
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }else{
            setCompoundDrawablesWithIntrinsicBounds(null,null,imgInable,null);
        }
    }
    //处理删除事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(imgInable != null && event.getAction() == MotionEvent.ACTION_DOWN){
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Log.e(TAG,"eventX = "+eventX+"; eventY="+eventY);
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 100;
            if(rect.contains(eventX,eventY)){
                setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
