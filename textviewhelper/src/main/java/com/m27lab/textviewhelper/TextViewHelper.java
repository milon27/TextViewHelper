package com.m27lab.textviewhelper;


import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;


public class TextViewHelper{

    private static TextView textView;
    private SpannableStringBuilder mSpanner;
    private boolean hasClickable;
    private static TextViewHelper mInstance;


    public TextViewHelper(TextView textView) {
        this.textView=textView;
        String full_text = textView.getText().toString().trim();
        this.mSpanner=new SpannableStringBuilder(full_text);
        this.hasClickable=false;
    }

    public static synchronized TextViewHelper getInstance(TextView textView){
        if (mInstance == null) {
            mInstance = new TextViewHelper(textView);
        }
        return mInstance;
    }

    //for single text color
    public TextViewHelper setTextColor(int color,int startIndex,int endIndex){
        ForegroundColorSpan sp = new ForegroundColorSpan(color);
        mSpanner.setSpan(sp, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return mInstance;
    }


    public TextViewHelper setTextClickable(ClickableSpan clickableSpan, int start_index, int end_index ){
        hasClickable=true;
        mSpanner.setSpan(clickableSpan,start_index,end_index,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return mInstance;
    }

    public void draw(){
        textView.setText(mSpanner);
        if(hasClickable) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }




}
