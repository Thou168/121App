package com.example.a121firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register_code extends AppCompatActivity {
    private Toolbar toolbar_register;
    private Button  btn_Verify;
    private EditText etVerify_Code;
    private TextView phone_number,textNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_code);

        toolbar_register = (Toolbar)findViewById(R.id.toolbar_register);
        toolbar_register.setTitle("Register");
        setSupportActionBar(toolbar_register);
        toolbar_register.setNavigationIcon(R.drawable.icon_back_30px);

        toolbar_register.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        phone_number = (TextView)findViewById(R.id.number_Phone);
        textNumber  = (TextView)findViewById(R.id.textNumber);
     String phone = getIntent().getStringExtra("phone_number");
     phone_number.setText(phone);

     textNumber.setText("We just send verify code to this "+ phone +" number. Enter the code from that message here");


    } // onCreate
}
