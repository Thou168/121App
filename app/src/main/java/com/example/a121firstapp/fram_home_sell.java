package com.example.a121firstapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class fram_home_sell extends AppCompatActivity {

    Toolbar toolbar;
    TextView vehicle,electronic,phone,computer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fram_home_sell);
        initToolBar();

        vehicle = (TextView)findViewById(R.id.txt_add_vehicle);
        vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Vehicle",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),data_sell_vehicle.class);
                startActivity(intent);
            }
        });

        electronic = (TextView)findViewById(R.id.txt_add_electronic);
        electronic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Electronic",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),data_sell_electronic.class);
                startActivity(intent);
            }
        });

        phone = (TextView)findViewById(R.id.txt_add_phone_tablet);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Phone & Tablet",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),data_sell_phone_and_tablet.class);
                startActivity(intent);
            }
        });

        computer = (TextView)findViewById(R.id.txt_add_computer_accessories);
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Computer & Accessories",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),data_sell_computer_and_accessories.class);
                startActivity(intent);
            }
        });

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_sell);
        setTitle("");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(fram_home_sell.this, "Home", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


}
