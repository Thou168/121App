package com.example.a121firstapp.Class_Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a121firstapp.Class_item.item_like;
import com.example.a121firstapp.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_like extends RecyclerView.Adapter<Adapter_like.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<item_like> items;

    public Adapter_like(Context context, ArrayList<item_like> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.image_your_like, viewGroup , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder view, int i) {
        item_like item = items.get(i);
//        view.imageView.setImageResource(item.getImage());
//        view.image_user.setImageResource(item.getImage_user());
//        view.name_user.setText(item.getName_user());
//        view.price.setText(Double.toString(item.getPrice()));
//        view.time.setText(item.getTime());
//        view.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image_user;
        ImageView imageView;
        TextView name_user;
        TextView price;
        TextView time;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            image_user = itemView.findViewById(R.id.img_user);
//            imageView = itemView.findViewById(R.id.img_view);
//            name_user = itemView.findViewById(R.id.user);
//            price = itemView.findViewById(R.id.tv_price);
//            time = itemView.findViewById(R.id.tv_time);
//            title = itemView.findViewById(R.id.tv_title);
        }
    }
}
