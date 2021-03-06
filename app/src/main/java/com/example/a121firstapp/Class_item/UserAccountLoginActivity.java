package com.example.a121firstapp.Class_item;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a121firstapp.MainActivity;
import com.example.a121firstapp.R;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import org.json.JSONArray;
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

public class UserAccountLoginActivity extends AppCompatActivity {
    private EditText Username,Password;
    private Button btnSubmit;
    private static final String TAG = "Response";
    private Context context;
    ProgressDialog mProgress;
    SharedPreferences prefer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_login);

        Username = (EditText)findViewById(R.id.editPhoneLogin);
        Password = (EditText)findViewById(R.id.editPasswordLogin);
        btnSubmit = (Button)findViewById(R.id.btnSubmitLogin);

        prefer = getSharedPreferences("Register",MODE_PRIVATE);

        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Please wait...");
        mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgress.setCancelable(false);
        mProgress.setIndeterminate(true);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.show();
                try {
                    postRequest();
                } catch (IOException e) {
                    e.printStackTrace();
                    mProgress.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                    mProgress.dismiss();
                }
            }
        });
    }

    public void postRequest() throws IOException, JSONException {
        String name = Username.getText().toString();
        String pass= Password.getText().toString();


        MediaType MEDIA_TYPE = MediaType.parse("application/json");
        String url ="http://192.168.1.239:8000/rest-auth/login/";  // login

        OkHttpClient client = new OkHttpClient();
        JSONObject postdata = new JSONObject();
        try {
            postdata.put("username", name);
            postdata.put("password", pass);

        } catch(JSONException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                //call.cancel();
            }


            @Override
            public void onResponse(Call call, final Response response) throws IOException {


                final String mMessage = response.body().string();
                Log.e(TAG, mMessage);
                converting(mMessage);

            }
        });
    }

    private void converting(String mMessage) {
        Gson gson = new Gson();
        Convert_Json_Java convertJsonJava = new Convert_Json_Java();
        try{
            convertJsonJava = gson.fromJson(mMessage,Convert_Json_Java.class);
            Log.d(TAG, convertJsonJava.getUsername() + "\t" + convertJsonJava.getEmail() + "\t" + convertJsonJava.getKey() + "\t" + convertJsonJava.getStatus());
            final String key = convertJsonJava.getKey();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (key!=null){
                        SharedPreferences.Editor editor = prefer.edit();
                        editor.putString("token",key);
                        editor.commit();

                        mProgress.dismiss();
                        Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserAccountLoginActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }else {
                        mProgress.dismiss();
                        Toast.makeText(getApplicationContext(),"Login failure",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }catch (JsonParseException e){
            e.printStackTrace();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),"Login failure",Toast.LENGTH_SHORT).show();
                    mProgress.dismiss();
                }
            });
        }

    }
}
