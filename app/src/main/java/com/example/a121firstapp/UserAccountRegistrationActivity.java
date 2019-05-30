package com.example.a121firstapp;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.wifi.hotspot2.pps.Credential;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class UserAccountRegistrationActivity extends AppCompatActivity  {
    ImageButton btnFacebookLogin;
    private Button btnSubmit;
    private EditText editPhone,editPassword,editComfirm;
    private TextInputLayout textInputLayout1,textInputLayout2,textInputLayout3;
    private TextInputEditText editphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_registration);

        editPhone = (TextInputEditText)findViewById(R.id.editPhone);
        editPassword = (EditText)findViewById(R.id.editPassword);
        editComfirm = (EditText)findViewById(R.id.editConfirm);
        textInputLayout1 = (TextInputLayout)findViewById(R.id.textinputlayoutphone);
        textInputLayout1.setErrorEnabled(true);
        textInputLayout2 = (TextInputLayout)findViewById(R.id.textinputlayoutpassword);
        textInputLayout3 = (TextInputLayout)findViewById(R.id.textinputlayoutconfirmpassword);

        btnFacebookLogin = (ImageButton)findViewById(R.id.btnFacebookLogin);
        btnFacebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(),UserAccountRegisterFacebookActivity.class);
                startActivity(i);
            }
        });

        btnSubmit = (Button)findViewById(R.id.btnSub);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Phone_number() | !Password() | !Comfirm()){
                   return;
                }else {
                    Intent intent = new Intent(v.getContext(),Register_code.class);
                    intent.putExtra("phone_number",editPhone.getText().toString());
                    startActivity(intent);
                }
            }
        });


    }
    private boolean Phone_number(){
        String phone = textInputLayout1.getEditText().getText().toString().trim();
        if (phone.isEmpty()){
            textInputLayout1.setError("Missing Password");
            textInputLayout1.requestFocus();
            editPhone.setBackgroundColor(Color.WHITE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    editPhone.setBackgroundResource(R.drawable.my_border1);
                }
            }, 50);
            return false;
        }else {
            textInputLayout1.setError(null);
            textInputLayout1.setErrorEnabled(false);

            return true;
        }
    }

    private boolean Password(){
        String password = editPassword.getText().toString().trim();
        if (password.isEmpty()){
            textInputLayout2.setError("Missing Password");
            textInputLayout2.requestFocus();
            editPassword.setBackgroundColor(Color.WHITE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    editPassword.setBackgroundResource(R.drawable.my_border1);
                }
            }, 50);
            return false;
        }else {
            textInputLayout2.setError(null);
            return true;
        }
    }

    private boolean Comfirm(){
        String confirm = editComfirm.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        if (confirm.isEmpty()){

            textInputLayout3.setError("Missing Comfirm Password");
            editComfirm.setBackgroundColor(Color.TRANSPARENT);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    editComfirm.setBackgroundResource(R.drawable.my_border1);
                }
            }, 50);
            return false;
        }else if(password.equals(confirm)) {
                textInputLayout3.setError(null);
                return true;
        }else{

            textInputLayout3.setError("Comfirm Password must the same Password");
            editComfirm.setBackgroundColor(Color.TRANSPARENT);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    editComfirm.setBackgroundResource(R.drawable.my_border1);
                }
            }, 50);
            return false;
        }
    }

}
