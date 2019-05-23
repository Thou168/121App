package com.example.a121firstapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a121firstapp.Class_Adapter.List_Adapter_Sell_Computer_and_accessories;
import com.example.a121firstapp.Class_Adapter.List_Adapter_Sell_Phone_and_Tablet;

public class data_sell_computer_and_accessories extends AppCompatActivity {
    ListView list;
    Toolbar toolbar;

    String[] name = {
            "Asus New Model",
            "Computer",
            "Consider Buying Computer Accessories",
            "Fujitsu Laptop",
            "Headsets Speakers SDKT",
            "Keyboard Product",
            "Mouse DKT",
            "Rosegold Macbook FT1",
            "Tablet and Accessories",
            "Ups Desktop"
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
            "$ 390",
            "$ 600",
    } ;

    Integer[] imageId = {
            R.drawable.asus_new,
            R.drawable.computer,
            R.drawable.consider_buying_computer_accessories,
            R.drawable.fujitsu_laptop,
            R.drawable.headsets_speakersdkt,
            R.drawable.keyboard_product,
            R.drawable.mousedkt,
            R.drawable.rosegold_macbookft1,
            R.drawable.tablet_and_accessories,
            R.drawable.ups_desktop,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_sell_computer_and_accessories);
        initToolBar();

        List_Adapter_Sell_Computer_and_accessories adapter = new List_Adapter_Sell_Computer_and_accessories(data_sell_computer_and_accessories.this, name,price, imageId);

        list =(ListView)findViewById(R.id.list_sell_computer_and_accessories);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "" +name[+ position], Toast.LENGTH_SHORT).show();
//                String Temp_computer_and_accessories = name[position].toString();
//
//                Intent intent = new Intent(data_sell_computer_and_accessories.this,data_sell_computer_details.class);
//                intent.putExtra("ListViewClickValue",Temp_computer_and_accessories);
//                startActivity(intent);
            }
        });

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_computer_and_accessories);
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