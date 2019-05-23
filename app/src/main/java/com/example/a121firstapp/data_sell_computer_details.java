package com.example.a121firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class data_sell_computer_details extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_sell_computer_details);

        textView = (TextView)findViewById(R.id.txtitem_computer);

        String Tempholder = getIntent().getStringExtra("Listviewclickvalue");
        textView.setText(Tempholder);
    }
}
