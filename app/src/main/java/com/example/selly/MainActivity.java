package com.example.selly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button hidden_button;
    Button hidden_buttonn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hidden_button=(Button) findViewById(R.id.hidden_button);
       hidden_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,Mokhaberat_Activity.class);
               startActivity(intent);
           }
       });
       hidden_buttonn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,Simcart_Activity.class);
               startActivity(intent);
           }
       });
    }

}
