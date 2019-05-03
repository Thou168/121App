package com.example.a121firstapp.Class_Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a121firstapp.Class_item.Item_in_post;
import com.example.a121firstapp.R;

import java.util.ArrayList;

public class Adapter_in_post extends RecyclerView.Adapter<Adapter_in_post.ReyclerViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<Item_in_post> items;

    public Adapter_in_post(Context context, ArrayList<Item_in_post> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
    }

    @Override
    public ReyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = layoutInflater.inflate(R.layout.detail_in_post, parent, false);

        return new ReyclerViewHolder(item);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ReyclerViewHolder holder, int position) {
        final Item_in_post item = items.get(position);

        holder.image_view.setImageResource(item.getImage_view());
        holder.brand.setText(item.getBrand());
        holder.post_on.setText(item.getPost_on());
        holder.renew_on.setText(item.getRenew_on());
        holder.price.setText(Double.toString(item.getPrice()));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ReyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_view;
        public TextView brand,post_on,renew_on,price;

        private ReyclerViewHolder(final View v) {
            super(v);
            this.image_view = (ImageView)itemView.findViewById(R.id.image_view);
            this.brand = (TextView)itemView.findViewById(R.id.txtbrand);
            this.post_on = (TextView)itemView.findViewById(R.id.txtposton);
            this.renew_on = (TextView)itemView.findViewById(R.id.txtrenew);
            this.price=(TextView)itemView.findViewById(R.id.txtprice);

        }
    }
}
