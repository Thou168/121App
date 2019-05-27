package com.example.a121firstapp.Class_Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a121firstapp.R;

public class List_Adapter_Sell_Phone_and_Tablet extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] name,price;
    private final Integer[] imageId;
    public List_Adapter_Sell_Phone_and_Tablet(Activity context,
                                              String[] name, String[] price, Integer[] imageId) {
        super(context, R.layout.list_sell_phone_and_tablet, name);
        this.context = context;
        this.name = name;
        this.price = price;
        this.imageId = imageId;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_sell_phone_and_tablet, null, true);

        TextView txtName = (TextView) rowView.findViewById(R.id.txt_name_phone_and_tablet);
        TextView txtPrice = (TextView) rowView.findViewById(R.id.txt_price_phone_and_tablet);
        ImageView imageSell = (ImageView) rowView.findViewById(R.id.img_sell_phone_and_tablet);

        txtName.setText(name[position]);
        txtPrice.setText(price[position]);
        imageSell.setImageResource(imageId[position]);
        return rowView;
    }
}
