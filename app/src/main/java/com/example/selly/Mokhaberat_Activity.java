package com.example.selly;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import com.airbnb.lottie.LottieAnimationView;

public class Mokhaberat_Activity extends AppCompatActivity {

    Button hidden_button_back;
    Button hidden_button;
    EditText editText;
    LottieAnimationView animationView;

    public String link = "https://charge.sep.ir/Inquiry/FixedLineBillInquiry";
    OkHttpClient okHttpClient = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mokhaberat);
        hidden_button_back = (Button) findViewById(R.id.hidden_button_back) ;
        hidden_button = (Button) findViewById(R.id.hidden_button) ;
        editText = findViewById(R.id.editText);
        animationView = findViewById(R.id.animation);
        animationView.setAnimation("lf20_ip5whBLzkg.json");
        animationView.playAnimation();

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
                try {
                    inquiry(editText.getText().toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    void inquiry(String fixedLineNumber) throws IOException {
        RequestBody body = RequestBody.create(JSON, "{FixedLineNumber: " + fixedLineNumber + "}");
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
                        Toast.makeText(Mokhaberat_Activity
                                        .this, "ارتباط برقرار نشد!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            assert response.body() != null;
                            String jsonData = response.body().string();
                            JSONObject object = new JSONObject(jsonData);
                            if (object.getString("code").equals("0")) {
                                Bundle bundle = new Bundle();
                                bundle.putString("data", object.getString("data"));
                                Intent intent = new Intent(Mokhaberat_Activity.this,
                                        Mokhaberat2_Activity.class);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Mokhaberat_Activity.this, object.getString("message"),
                                        Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException | IOException e) {
                            Toast.makeText(Mokhaberat_Activity.this, "ارتباط برقرار نشد!",
                                    Toast.LENGTH_SHORT).show();
                            call.cancel();
                        }
                    }
                });
            }
        });
    }
}