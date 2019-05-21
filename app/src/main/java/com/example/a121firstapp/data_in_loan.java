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

import com.example.a121firstapp.Class_Adapter.Adapter_in_loan;
import com.example.a121firstapp.Class_item.Item_in_loan;

import java.util.ArrayList;

public class data_in_loan extends Fragment implements Adapter_in_loan.ItemListener{
    private ArrayList<Item_in_loan> items;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.data_in_loan, container, false);

        createItem();

        RecyclerView recy_vertical = (RecyclerView) view.findViewById(R.id.recy_in_loan);
        Adapter_in_loan adapter1 = new Adapter_in_loan(getContext(), items, this);
        recy_vertical.setAdapter(adapter1);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        recy_vertical.setLayoutManager(manager);

        return view;
    }
    private void createItem(){
        items = new ArrayList<>();
        items.add( new Item_in_loan(R.drawable.image_honda_click125i_19,"Click 125",15));
        items.add( new Item_in_loan(R.drawable.image_honda_dream,"Honda",1900));
        items.add( new Item_in_loan(R.drawable.image_nex,"Nex",1400));
        items.add( new Item_in_loan(R.drawable.image_zoomer_x_2017,"Honda Zoomer X",2100));

    }

    @Override
    public void onItemClick(Item_in_loan item) {
//        Toast.makeText(getContext(),"Click item"+item.getBrand(),Toast.LENGTH_SHORT).show();

    }
}
