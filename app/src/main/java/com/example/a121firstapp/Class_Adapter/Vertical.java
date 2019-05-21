package com.example.a121firstapp.Class_Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a121firstapp.Class_item.Item_vertical;
import com.example.a121firstapp.R;

import java.util.ArrayList;

/*
 * Created by Sambhaji Karad on 04-Jan-18
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

public class Vertical extends RecyclerView.Adapter<Vertical.ViewHolder> {

    private ArrayList<Item_vertical> mValues;
    private Context mContext;
    protected ItemListener mListener;

    public Vertical(Context context, ArrayList<Item_vertical> values, ItemListener itemListener) {
        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtbreand,txtprice,txtLocation;
        private ImageView imageView;
        private RelativeLayout relativeLayout;
        private Item_vertical item;
        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            txtbreand = (TextView) v.findViewById(R.id.txtbrand);
            txtLocation=(TextView) v.findViewById(R.id.txtlocation);
            txtprice = (TextView) v.findViewById(R.id.txtprice);
            imageView = (ImageView) v.findViewById(R.id.image_view);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);
        }
        public void setData(Item_vertical item) {
            this.item = item;
            txtbreand.setText(item.getBrand());
            txtLocation.setText(item.getLocation());
            txtprice.setText(Double.toString(item.getPrice()));
            imageView.setImageResource(item.getImage_view());
            //relativeLayout.setBackgroundColor(Color.parseColor(item.color));
        }
        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_new_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.setData(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(Item_vertical item);
    }
}