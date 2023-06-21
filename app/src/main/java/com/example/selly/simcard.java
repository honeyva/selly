package com.example.selly;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
public class simcard extends AppCompatActivity {
    Button hidden_button_back;
    RadioGroup radioGroup;
    EditText editTextnum;
    EditText editTextma;
    Button hidden_button;
    String sim;
    String link = "https://topup.pec.ir/";
    OkHttpClient okHttpClient = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simcard);
        editTextnum = findViewById(R.id.editTextnum);
        editTextma = findViewById(R.id.editTextma);
        radioGroup = findViewById(R.id.radioGroup);
        hidden_button = findViewById(R.id.hidden_button);
        hidden_button_back = findViewById(R.id.hidden_button_back);

        hidden_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(simcard.this, MainActivity.class);
                startActivity(intent);
            }
        });

        hidden_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioGroup.getCheckedRadioButtonId() == R.id.irancel) {
                    sim = "1";
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.hamrahaval) {
                    sim = "2";
                } else {
                    sim = "3";
                }
                try {
                    charge(editTextnum.getText().toString(), sim, editTextma.getText().toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    void charge(String number, String sim, String editTextma) throws IOException {

        RequestBody body = RequestBody.create(JSON, "{MobileNo: " + number + ",OperatorType: "
                + sim + "," + "AmountPure: " + editTextma + "}");
        Request request = new Request.Builder()
                .url(link)
                .post(body)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(simcard.this, "خطا در برقراری سرویس", Toast.LENGTH_SHORT).show();
                    }

                });
                call.cancel();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            assert response.body() != null;
                            String jsonData = response.body().string();
                            JSONObject jsonObject = new JSONObject(jsonData);
                            if (jsonObject.has("error")) {
                                Toast.makeText(simcard.this, jsonObject.get("error").toString()
                                        , Toast.LENGTH_SHORT).show();
                            } else {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(jsonObject.get("url").toString()));
                                startActivity(browserIntent);
                            }
                        } catch (IOException | JSONException e) {
                            Toast.makeText(simcard.this, "خطا در برقراری سرویس", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }
}