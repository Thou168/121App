package com.example.a121firstapp.Class_Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a121firstapp.Class_item.Item_in_pending;
import com.example.a121firstapp.R;

import java.util.ArrayList;

/*
 * Created by Sambhaji Karad on 04-Jan-18
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

public class Adapter_in_pending extends RecyclerView.Adapter<Adapter_in_pending.ViewHolder> {

    private ArrayList<Item_in_pending> mValues;
    private Context mContext;
    protected ItemListener mListener;

    public Adapter_in_pending(Context context, ArrayList<Item_in_pending> values, ItemListener itemListener) {
        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtbreand,txtposton,txtrenew,txtprice;
        private ImageView imageView;
        private Item_in_pending item;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            txtbreand = (TextView) v.findViewById(R.id.txtbreand);
            txtprice = (TextView) v.findViewById(R.id.txtprice);
            imageView = (ImageView) v.findViewById(R.id.image_view);
            txtrenew = (TextView) v.findViewById(R.id.txtrenew);
            txtposton = (TextView) v.findViewById(R.id.txtposton);
        }

        public void setData(Item_in_pending item) {
            this.item = item;
            txtbreand.setText(item.getBrand());
            txtprice.setText(Double.toString(item.getPrice()));
            txtrenew.setText(item.getRenew_on());
            txtposton.setText(item.getPost_on());
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_in_panding, parent, false);
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
        void onItemClick(Item_in_pending item);
    }
}