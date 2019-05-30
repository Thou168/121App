package com.example.a121firstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a121firstapp.Class_Adapter.List_Adapter_Buy_Electronic;
import com.example.a121firstapp.Class_Adapter.List_Adapter_Rent_Electronic;

public class data_buy_electronic extends AppCompatActivity {
    ListView list;
    Toolbar toolbar;

    String[] name = {
            "DVD vcd",
            "Telecom",
            "TV HD",
            "LED TV Repair",
            "LG Mobile Device",
    } ;

    String[] price = {
            "$ 2000",
            "$ 5000",
            "$ 2300",
            "$ 300",
            "$ 100",
    } ;

    Integer[] imageId = {
            R.drawable.electronic_1,
            R.drawable.electronic_2,
            R.drawable.electronic_3,
            R.drawable.led_tv_repair,
            R.drawable.lg_mobile_device,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_buy_electronic);
        initToolBar();

        List_Adapter_Buy_Electronic adapter = new
                List_Adapter_Buy_Electronic(data_buy_electronic.this, name,price, imageId);
        list=(ListView)findViewById(R.id.list_buy_electronic);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(view.getContext(), "" +name[+ position], Toast.LENGTH_SHORT).show();
//                if (position == 0) {
//                    Intent myIntent = new Intent(view.getContext(), data_electronic_click.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 1) {
//                    Intent myIntent = new Intent(view.getContext(), data_electronic_click.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 2) {
//                    Intent myIntent = new Intent(view.getContext(), data_electronic_click.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 3) {
//                    Intent myIntent = new Intent(view.getContext(), data_electronic_click.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 4) {
//                    Intent myIntent = new Intent(view.getContext(), data_electronic_click.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 5) {
//                    Intent myIntent = new Intent(view.getContext(), data_electronic_click.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 6) {
//                    Intent myIntent = new Intent(view.getContext(), data_electronic_click.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 7) {
//                    Intent myIntent = new Intent(view.getContext(), data_electronic_click.class);
//                    startActivityForResult(myIntent, 0);
//                }

            }
        });

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_electronic);
        setTitle("");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Buy", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}