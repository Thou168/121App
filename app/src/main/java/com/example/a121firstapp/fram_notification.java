package com.example.a121firstapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a121firstapp.Class_Adapter.Adapter_in_order;
import com.example.a121firstapp.Class_Adapter.AppNavigation;
import com.example.a121firstapp.Class_item.Item_order_list;

import java.util.ArrayList;

public class fram_notification extends Fragment implements Adapter_in_order.ItemListener {
    private ArrayList<Item_order_list> items;
    private String notificationType="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fram_notification, container, false);

        Toolbar toolbar_home = (Toolbar) view.findViewById(R.id.toolbar_notification);
        setHasOptionsMenu(true);
        TextView toolbar_title = (TextView) view.findViewById(R.id.toolbar_title);

        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar_home,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        AppNavigation.setupDrawerContent(getContext(),navigationView,drawer,getActivity());
        if(getArguments()!=null) {
            notificationType = getArguments().getString("type");
            if(notificationType.equals("post")){
                toolbar_title.setText(getString(R.string.txt_postlist));
            }
            else if(notificationType.equals("loan")){
                toolbar_title.setText(getString(R.string.txt_loanlist));
            }
            else if(notificationType.equals("order")){
                toolbar_title.setText(getString(R.string.txt_your_order));
            }
        }else
            toolbar_title.setText(getString(R.string.txt_approval));

        createItem();
        RecyclerView recy_vertical = (RecyclerView) view.findViewById(R.id.recy_notification);
        Adapter_in_order adapter1 = new Adapter_in_order(getContext(), items, this);
        recy_vertical.setAdapter(adapter1);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        recy_vertical.setLayoutManager(manager);

        return view;
    }
    private void createItem(){
        items = new ArrayList<>();
        items.add( new Item_order_list(R.drawable.image_honda_dream,"Honda",2010,"hoka","new ",3000));
        items.add( new Item_order_list(R.drawable.image_nex,"Nex 2018", 1009,"kola","Used",1000));
        items.add(new Item_order_list(R.drawable.image_zoomer_x_2017,"Zoomer x",4000,"youka","old",2100));
        items.add(new Item_order_list(R.drawable.image_hybrid_2017,"Hybrid 2017",34000,"Thean","oldest",2700));
        items.add( new Item_order_list(R.drawable.image_nex,"Nex 3x",400,"Maki","New",100));
        items.add(new Item_order_list(R.drawable.image_honda_click125i_19,"Click2018",2700,"Soka","Uesed",4100));
    }

    @Override
    public void onItemClick(Item_order_list item) {

    }
}
