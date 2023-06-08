package com.example.selly;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class simcard extends AppCompatActivity {
Button hidden_button_back;
Button hidden_button_irancle;
Button hidden_button_hamrah;
Button hidden_button_raitel;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simcard);
        hidden_button_back = (Button) findViewById(R.id.hidden_button_back);
        hidden_button_irancle = (Button) findViewById(R.id.hidden_button_irancle);
        hidden_button_hamrah = (Button) findViewById(R.id.hidden_button_hamrah);
        hidden_button_raitel = (Button) findViewById(R.id.hidden_button_raitel);

        hidden_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(simcard.this,MainActivity.class);
                startActivity(intent);
            }
        });

//        hidden_button_irancle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(simcard.this,.class);
//                startActivity(intent);
//            }
//        });

//        hidden_button_hamrah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(simcard.this,.class);
//                startActivity(intent);
//            }
//        });
//        hidden_button_raitel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(simcard.this,.class);
//                startActivity(intent);
//            }
//        });
    }
}