package com.example.selly;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mokhaberat2_Activity extends AppCompatActivity {
Button hidden_button_back;
Button hidden_button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mokhaberat2);
        hidden_button_back=(Button) findViewById(R.id.hidden_button_back);
        hidden_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mokhaberat2_Activity.this,Mokhaberat_Activity.class);
                startActivity(intent);
            }
        });
//         (نیاز به ادیت نام صفحه)اینجا کد دکمه ای نوشته میشود ک وقتی روی دکمه ثبت کلیک شد چه کاری انجام شود
//        hidden_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(.this, .class);
//                startActivity(intent);
//            }
//            });

        }

}