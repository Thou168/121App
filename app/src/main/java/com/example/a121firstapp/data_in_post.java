package com.example.a121firstapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a121firstapp.Class_Adapter.Adapter_in_post;
import com.example.a121firstapp.Class_item.Item_in_post;

import java.util.ArrayList;

public class data_in_post extends Fragment {
    private ArrayList<Item_in_post> items;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.data_in_post, container, false);

        creatItem();
        Adapter_in_post adapter1 = new Adapter_in_post(getContext(),items);
        RecyclerView recy_vertical = (RecyclerView) view.findViewById(R.id.recy_in_post);
        recy_vertical.setLayoutManager(new GridLayoutManager(getContext(),1));
        recy_vertical.setHasFixedSize(true);
        recy_vertical.setAdapter(adapter1);

        return view;
    }
    private void creatItem(){
        items = new ArrayList<>();
        items.add( new Item_in_post(R.drawable.image_honda_click125i_19,"Click 125","2 ago","2 ago",1500));
        items.add( new Item_in_post(R.drawable.image_honda_dream,"Honda","3 ago","3 ago",1900));
        items.add( new Item_in_post(R.drawable.image_nex,"Nex","1 ago","1 ago",1400));
        items.add( new Item_in_post(R.drawable.image_zoomer_x_2017,"Honda Zoomer X","4 ago","4 ago",2100));
        items.add( new Item_in_post(R.drawable.image_hybrid_2017,"Car Hybrid","5 ago","5 ago",200450));
        items.add( new Item_in_post(R.drawable.image_macbook_pro_2018,"Apple Macbook","3 ago","3 ago",1700));
        items.add( new Item_in_post(R.drawable.image_hybrid_2017,"Honda Hybrid 2017","5h ago"," 4h ago",3000));
    }
}
