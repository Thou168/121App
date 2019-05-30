package com.example.a121firstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a121firstapp.Class_Adapter.List_Adapter_Rent_House;

public class data_rent_house extends AppCompatActivity {
    ListView list;
    Toolbar toolbar;

    String[] name = {
            "Bedroom house for rent in BKK",
            "Thai house",
            "Villa for rent in phnom penh",
            "Shophouse in phnom penh",
            "Nest cambodia house",
            "Hotel in takeo",
            "Apartment BKK"
    } ;

    String[] price = {
            "$ 2000",
            "$ 5000",
            "$ 2300",
            "$ 6000",
            "$ 2200",
            "$ 2350",
            "$ 5000"
    } ;

    Integer[] imageId = {
            R.drawable.bedroom_house_for_rent_in_bangkok,
            R.drawable.thai_house_style,
            R.drawable.villa_for_rent_in_phnom_penh,
            R.drawable.shophouse_in_phnom_penh,
            R.drawable.nest_cambodia_house,
            R.drawable.hotel_in_takeo,
            R.drawable.apartment_bkk

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_rent_house);
        initToolBar();

        List_Adapter_Rent_House adapter = new
                List_Adapter_Rent_House(data_rent_house.this, name,price, imageId);
        list=(ListView)findViewById(R.id.list_rent_house);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(view.getContext(), "" +name[+ position], Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_house);
        setTitle("");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Rent", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}