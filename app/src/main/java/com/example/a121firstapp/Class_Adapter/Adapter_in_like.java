package com.example.a121firstapp.Class_Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a121firstapp.Class_item.Item_in_like;
import com.example.a121firstapp.R;

import java.util.ArrayList;

public class Adapter_in_like extends RecyclerView.Adapter<Adapter_in_like.ViewHolder> {

    private ArrayList<Item_in_like> mValues;
    private Context mContext;
    protected ItemListener mListener;

    public Adapter_in_like(Context context, ArrayList<Item_in_like> values, ItemListener itemListener) {
        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtbreand,txttotal,txtLocation;
        private ImageView imageView;
        private Item_in_like item;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            txtbreand = (TextView) v.findViewById(R.id.txtbrand);
            imageView = (ImageView) v.findViewById(R.id.image_view);
            txttotal = (TextView) v.findViewById(R.id.txttotal);
            txtLocation=(TextView) v.findViewById(R.id.txtLocation);
        }

        public void setData(Item_in_like item) {
            this.item = item;
            txtbreand.setText(item.getBrand());
            imageView.setImageResource(item.getImage_view());
            txttotal.setText(Integer.toString(item.getTotal()));
            txtLocation.setText(item.getLocation());
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_in_like, parent, false);
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
        void onItemClick(Item_in_like item);
    }
}