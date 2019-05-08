package com.example.a121firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class UserAccountRegistrationActivity extends AppCompatActivity {
    ImageButton btnFacebookLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_registration);

        btnFacebookLogin = (ImageButton)findViewById(R.id.btnFacebookLogin);
        btnFacebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(),UserAccountRegisterFacebookActivity.class);
                startActivity(i);
            }
        });


    }


}
