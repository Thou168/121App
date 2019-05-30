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

import com.example.a121firstapp.Class_Adapter.Adapter_in_pending;
import com.example.a121firstapp.Class_item.Item_in_pending;

import java.util.ArrayList;



public class data_in_panding extends Fragment implements Adapter_in_pending.ItemListener{
    private ArrayList<Item_in_pending> items;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.data_in_panding, container, false);

        creatItem();
        RecyclerView recy_vertical = (RecyclerView) view.findViewById(R.id.recy_in_pending);
        Adapter_in_pending adapter1 = new Adapter_in_pending(getContext(), items, this);
        recy_vertical.setAdapter(adapter1);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        recy_vertical.setLayoutManager(manager);

        return view;
    }
    private void creatItem(){
        items = new ArrayList<>();
        items.add( new Item_in_pending(R.drawable.image_honda_click125i_19,"Click 125","2 ago","2 ago",1500));
        items.add( new Item_in_pending(R.drawable.image_honda_dream,"Honda","3 ago","3 ago",1900));
        items.add( new Item_in_pending(R.drawable.image_nex,"Nex","1 ago","1 ago",1400));
        items.add( new Item_in_pending(R.drawable.image_zoomer_x_2017,"Honda Zoomer X","4 ago","4 ago",2100));
    }

    @Override
    public void onItemClick(Item_in_pending item) {

    }
}


