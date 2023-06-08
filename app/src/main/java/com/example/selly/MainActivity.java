package com.example.selly;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button hidden_button_mokhaberat;
Button hidden_buttonn_simcard;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hidden_button_mokhaberat=(Button) findViewById(R.id.hidden_button_mokhaberat);
        hidden_buttonn_simcard=(Button) findViewById(R.id.hidden_button_simcard);

        hidden_button_mokhaberat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,Mokhaberat_Activity.class);
               startActivity(intent);
           }
       });
       hidden_buttonn_simcard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,simcard.class);
               startActivity(intent);
           }
       });
    }

}
