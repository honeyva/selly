package com.example.selly;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mokhaberat_Activity extends AppCompatActivity {
    Button hidden_button_back;
    Button hidden_button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mokhaberat);
        hidden_button_back=(Button) findViewById(R.id.hidden_button_back) ;
        hidden_button=(Button) findViewById(R.id.hidden_button) ;

        hidden_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mokhaberat_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        hidden_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mokhaberat_Activity.this,Mokhaberat2_Activity.class);
                startActivity(intent);
            }
        });
    }
}