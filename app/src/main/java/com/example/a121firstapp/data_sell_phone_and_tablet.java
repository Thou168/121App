package com.example.a121firstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a121firstapp.Class_Adapter.List_Adapter_Sell_Phone_and_Tablet;

public class data_sell_phone_and_tablet extends AppCompatActivity {
    ListView list;
    Toolbar toolbar;

    String[] name = {
            "Google Taiman BLK",
            "Noted Tablet",
            "Nu M5",
            "Samsung GalaxyTabs4 Black",
            "Tablet and Accessories",
            "Techno Mobile",
            "U20 Plus Web1",
            "ZTE ZPad 10inch",
    } ;

    String[] price = {
            "$ 2000",
            "$ 5000",
            "$ 2300",
            "$ 300",
            "$ 100",
            "$ 205",
            "$ 390",
            "$ 600",
    } ;

    Integer[] imageId = {
            R.drawable.google_taiman_blk,
            R.drawable.noted_tablet,
            R.drawable.nu_m5,
            R.drawable.samsung_galaxytabs4_black,
            R.drawable.tablet_and_accessories,
            R.drawable.techno_mobile,
            R.drawable.u20_plus_web1,
            R.drawable.zte_zpad_10inch,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_sell_phone_and_tablet);
        initToolBar();

        List_Adapter_Sell_Phone_and_Tablet adapter = new
                List_Adapter_Sell_Phone_and_Tablet(data_sell_phone_and_tablet.this, name,price, imageId);

        list=(ListView)findViewById(R.id.list_sell_phone_and_tablet);
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
        toolbar = (Toolbar) findViewById(R.id.toolbar_phone_and_tablet);
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