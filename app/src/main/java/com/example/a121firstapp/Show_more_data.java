package com.example.a121firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.a121firstapp.Class_Adapter.Adapter_show_all;
import com.example.a121firstapp.Class_item.Item_horizotal;

import java.util.ArrayList;

public class Show_more_data extends AppCompatActivity {

    ArrayList<Item_horizotal> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_more_data);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        items = new ArrayList<Item_horizotal>();
        items = (ArrayList<Item_horizotal>)getIntent().getSerializableExtra("items");

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        Adapter_show_all adapter1 = new Adapter_show_all(getBaseContext(), (ArrayList<Item_horizotal>) items);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setAdapter(adapter1);
        GridLayoutManager manager = new GridLayoutManager(getBaseContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);


    }
}
