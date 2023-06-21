package com.example.selly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Mokhaberat2_Activity extends AppCompatActivity {
    Button hidden_button_back;
    Button hidden_button_backok;
    TextView bill_id,m_id,m_m,p_id,p_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mokhaberat2);
        hidden_button_back = findViewById(R.id.hidden_button_back);
        hidden_button_backok = findViewById(R.id.hidden_button_back1);

        hidden_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mokhaberat2_Activity.this, Mokhaberat_Activity.class);
                startActivity(intent);
            }
        });

        hidden_button_backok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mokhaberat2_Activity.this, Mokhaberat_Activity.class);
                startActivity(intent);
            }
        });

        p_id = findViewById(R.id.p_id);
        bill_id = findViewById(R.id.bill_id);
        m_m = findViewById(R.id.m_m);
        p_m = findViewById(R.id.p_m);
        m_id = findViewById(R.id.m_id);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            try {
                JSONObject object = new JSONObject(bundle.getString("data"));
                String midIdString = object.getJSONObject("MidTerm").getString("PaymentID");
                String finalIdString = object.getJSONObject("FinalTerm").getString("PaymentID");
                String billIdString = object.getJSONObject("FinalTerm").getString("BillID");
                String midAmountString = object.getJSONObject("MidTerm").getString("Amount");
                String finalAmountString = object.getJSONObject("FinalTerm").getString("Amount");

                m_m.setText(midAmountString);
                p_id.setText(finalIdString);
                bill_id.setText(billIdString);
                p_m.setText(finalAmountString);
                m_id.setText(midIdString);

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        }
    }
}