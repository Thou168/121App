package com.example.a121firstapp.Class_Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a121firstapp.R;

public class List_Adapter_Rent_House extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] name,price;
    private final Integer[] imageId;
    public List_Adapter_Rent_House(Activity context, String[] name, String[] price, Integer[] imageId) {
        super(context, R.layout.list_rent_house, name);
        this.context = context;
        this.name = name;
        this.price = price;
        this.imageId = imageId;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_rent_house, null, true);

        TextView txtName = (TextView) rowView.findViewById(R.id.txt_name_rent);
        TextView txtPrice = (TextView) rowView.findViewById(R.id.txt_price_rent);
        ImageView imageRent = (ImageView) rowView.findViewById(R.id.img);

        txtName.setText(name[position]);
        txtPrice.setText(price[position]);
        imageRent.setImageResource(imageId[position]);
        return rowView;
    }
}
