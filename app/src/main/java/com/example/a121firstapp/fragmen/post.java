package com.example.a121firstapp.fragmen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a121firstapp.Class_Adapter.List_Adapter_Sell_Vehicle;
import com.example.a121firstapp.Class_Adapter.Vertical;
import com.example.a121firstapp.Class_item.Item_vertical;
import com.example.a121firstapp.R;
import com.example.a121firstapp.View_buying_request_item_detail;

public class post extends Fragment implements  Vertical.ItemListener {

    ListView list;
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
    public post() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fram_post, container, false);

        List_Adapter_Sell_Vehicle adapter = new List_Adapter_Sell_Vehicle(getActivity(), name,price, imageId);
        list=(ListView)view.findViewById(R.id.listview);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             //   Toast.makeText(view.getContext(), "" +name[+ position], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), View_buying_request_item_detail.class);
                intent.putExtra("img_header",imageId[position]);
                intent.putExtra("brand",name[position]);
                intent.putExtra("price",price[position]);
                intent.putExtra("dic",0);
                getContext().startActivity(intent);

            }
        });

        return view;
    }

    @Override
    public void onItemClick(Item_vertical item) {

    }
}
