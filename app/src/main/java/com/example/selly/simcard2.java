package com.example.selly;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class simcard2 extends AppCompatActivity {
    Button hidden_button;
    Button hidden_button_back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simcard2);
        hidden_button_back = (Button) findViewById(R.id.hidden_button_back);
        hidden_button = (Button) findViewById(R.id.hidden_button);


        hidden_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(simcard2.this,simcard.class);
                startActivity(intent);
            }
        });
//         (نیاز به ادیت نام صفحه)اینجا کد دکمه ای نوشته میشود ک وقتی روی دکمه خرید شارژ کلیک شد چه کاری انجام شود
//        hidden_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(.this, .class);
//                startActivity(intent);
//            }
//            });
    }
}