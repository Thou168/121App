package com.example.a121firstapp;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.bumptech.glide.request.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAccountRegisterFacebookActivity extends AppCompatActivity {
    private static final String LOG_TAG=UserAccountRegistrationActivity.class.getSimpleName();
    private LoginButton loginButton;
    private static final String EMAIL = "email";
    private CallbackManager callbackManager;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_register_facebook);


        FacebookSdk.sdkInitialize(getApplication());
        show = (TextView)findViewById(R.id.txtshow);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        callbackManager = CallbackManager.Factory.create();

        Login();

        }

    private void Login() {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(UserAccountRegisterFacebookActivity.this,MainActivity.class);
                show.setText("Login success" + loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                show.setText("Cancel");
            }

            @Override
            public void onError(FacebookException error) {
                show.setText("Error: " + error.getMessage());
            }
        });
    }

    @Override
            protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

                super.onActivityResult(requestCode, resultCode, data);
                callbackManager.onActivityResult(requestCode, resultCode, data);
            }

}
