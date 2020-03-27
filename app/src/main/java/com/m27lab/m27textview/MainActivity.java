package com.m27lab.m27textview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/* *
 *
 * Example Code ,How to Use TextViewHelper library
 * author: @milon27
 *
 * */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtview=findViewById(R.id.txtview);
        txtview.setText("Note: This is important Notice,click here");

        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(getApplicationContext(),"click action",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                //ds.setColor(Color.MAGENTA);
                //ds.setUnderlineText(true);
            }
        };




        TextViewHelper.getInstance(txtview)
                .setTextColor(Color.MAGENTA,0,4)
                .setTextColor(Color.GREEN,10,24)
                .setTextClickable(clickableSpan,31,41)
                .draw();


    }
}
