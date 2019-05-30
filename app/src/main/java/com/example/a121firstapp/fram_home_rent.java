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

public class fram_home_rent extends AppCompatActivity {

    Toolbar toolbar;
    TextView house,electronic,phone,computer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fram_home_rent);
        initToolBar();

        house = (TextView)findViewById(R.id.txt_add_house);
        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Toast.makeText(v.getContext(),"House",Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(v.getContext(),data_rent_house.class);
                  startActivity(intent);

            }
        });

        electronic = (TextView)findViewById(R.id.txt_add_electronic);
        electronic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Electronic",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),data_rent_electronic.class);
                startActivity(intent);
            }
        });

        phone = (TextView)findViewById(R.id.txt_add_phone_tablet);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Phone & Tablet",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),data_rent_phone_and_tablet.class);
                startActivity(intent);
            }
        });

        computer = (TextView)findViewById(R.id.txt_add_computer_accessories);
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Computer & Accessories",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),data_rent_computer_and_accessories.class);
                startActivity(intent);
            }
        });

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_rent);
        setTitle("");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(fram_home_rent.this, "Home", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


}
