package com.example.a121firstapp.Class_Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a121firstapp.Class_item.Item_horizotal;
import com.example.a121firstapp.R;
import com.example.a121firstapp.View_buying_request_item_detail;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_show_all extends RecyclerView.Adapter<Adapter_show_all.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<Item_horizotal> items;

    public Adapter_show_all(Context context, ArrayList<Item_horizotal> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.image_horizontal, viewGroup , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder view, int i) {
        final Item_horizotal item = items.get(i);
        view.imageView.setImageResource(item.getImage_view());
        view.price.setText(Double.toString(item.getPrice()));
        view.o_price.setText(Double.toString(item.getDic()));
        view.o_price.setPaintFlags(view.o_price.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
//        view.time.setText(item.getTime());
        view.title.setText(item.getBrand());
        view.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), View_buying_request_item_detail.class);
                intent.putExtra("img_header",item.getImage_view());
                intent.putExtra("brand",item.getBrand());
                intent.putExtra("price",item.getPrice());
                intent.putExtra("dic",item.getDic());
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageButton imageButton;
        TextView name_user;
        TextView price,o_price;
        TextView time;
        TextView title;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            price = itemView.findViewById(R.id.txtprice);
//            time = itemView.findViewById(R.id.location);
            title = itemView.findViewById(R.id.txtbrand);
            o_price = itemView.findViewById(R.id.txtdic);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}
