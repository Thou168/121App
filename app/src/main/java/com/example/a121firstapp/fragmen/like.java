package com.example.a121firstapp.fragmen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a121firstapp.Class_Adapter.Adapter_like;
import com.example.a121firstapp.Class_item.item_like;
import com.example.a121firstapp.R;

import java.util.ArrayList;


public class like extends Fragment {

    public like() {
    }
    ArrayList<item_like> items;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  return inflater.inflate(R.layout.fram_like, container, false);
        View view = inflater.inflate(R.layout.fram_like,container,false);

        items = new ArrayList<>();
        items.add( new item_like(R.drawable.image_honda_dream,"Honda dream new 100%",2100.0));
        items.add( new item_like(R.drawable.image_macbook_pro_2018,"macbook new 100%",2100.0));
        items.add( new item_like(R.drawable.image_honda_dream,"Honda dream new 100%",2100.0));
        items.add( new item_like(R.drawable.image_honda_dream,"Honda dream new 100%",2100.0));
        items.add( new item_like(R.drawable.image_hybrid_2017,"Honda dream new 100%",2100.0));
        items.add( new item_like(R.drawable.image_honda_dream,"Honda dream new 100%",2100.0));

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        Adapter_like adapter1 = new Adapter_like(getContext(),items);
        RecyclerView recy_horizontal1 = (RecyclerView) view.findViewById(R.id.list_like);
        recy_horizontal1.setHasFixedSize(true);
        recy_horizontal1.setLayoutManager(layoutManager1);
        recy_horizontal1.setAdapter(adapter1);

        return view;
    }
}
