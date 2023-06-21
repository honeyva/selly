package com.example.selly;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mokhaberat2_Activity extends AppCompatActivity {
Button hidden_button_back;
Button getHidden_button_backok;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mokhaberat2);
        hidden_button_back=(Button) findViewById(R.id.hidden_button_back);
        Button hidden_button_backok = (Button) findViewById(R.id.hidden_button_back1);

        hidden_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mokhaberat2_Activity.this,Mokhaberat_Activity.class);
                startActivity(intent);
            }
        });
        hidden_button_backok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mokhaberat2_Activity.this,Mokhaberat_Activity.class);
                startActivity(intent);
            }
            });

        }

}