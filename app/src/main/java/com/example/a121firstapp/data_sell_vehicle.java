package com.example.a121firstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a121firstapp.Class_Adapter.List_Adapter_Sell_Vehicle;

public class data_sell_vehicle extends AppCompatActivity {
    ListView list;
    Toolbar toolbar;

    String[] name = {
            "Honda dream red",
            "Duke C390 2019",
            "Scoopy 2019",
            "Hybrid 2019",
            "Zoomer X 2019",
            "MSX 2019",
            "Roll Royce"
    } ;

    String[] price = {
            "$ 2000",
            "$ 5000",
            "$ 2300",
            "$ 12000",
            "$ 2200",
            "$ 2350",
            "$ 1000000"
    } ;

    Integer[] imageId = {
            R.drawable.dream_red,
            R.drawable.duke_c390_2019,
            R.drawable.scopy_2019,
            R.drawable.image_hybrid_2017,
            R.drawable.zoomer_x,
            R.drawable.msx_2019,
            R.drawable.roll_royce_2019

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_sell_vehicle);
        initToolBar();

        List_Adapter_Sell_Vehicle adapter = new
                List_Adapter_Sell_Vehicle(data_sell_vehicle.this, name,price, imageId);
        list=(ListView)findViewById(R.id.list_sell_vehicle);
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
        toolbar = (Toolbar) findViewById(R.id.toolbar_vehicle);
        setTitle("");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Sell", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}