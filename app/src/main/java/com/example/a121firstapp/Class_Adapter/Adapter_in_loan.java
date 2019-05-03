package com.example.a121firstapp.Class_Adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a121firstapp.Class_item.Item_in_loan;
import com.example.a121firstapp.R;

import java.util.ArrayList;

/*
 * Created by Sambhaji Karad on 04-Jan-18
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

public class Adapter_in_loan extends RecyclerView.Adapter<Adapter_in_loan.ViewHolder> {

    private ArrayList<Item_in_loan> mValues;
    private Context mContext;
    protected ItemListener mListener;

    public Adapter_in_loan(Context context, ArrayList<Item_in_loan> values, ItemListener itemListener) {
        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtbreand,txttotal;
        private ImageView imageView;
       // private RelativeLayout relativeLayout;
        ImageButton btn_next;
        private Item_in_loan item;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            txtbreand = (TextView) v.findViewById(R.id.txtbrand);
            imageView = (ImageView) v.findViewById(R.id.image_view);
            txttotal = (TextView) v.findViewById(R.id.txttotal);
            btn_next = (ImageButton) v.findViewById(R.id.btn_next);
        }

        public void setData(final Item_in_loan item) {
            this.item = item;
            txtbreand.setText(item.getBrand());
            txttotal.setText(Integer.toString(item.getTotal()));
            imageView.setImageResource(item.getImage_view());
            //relativeLayout.setBackgroundColor(Color.parseColor(item.color));
            btn_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),item.getBrand()+" Total "+Integer.toString(item.getTotal()),Toast.LENGTH_SHORT).show();
                }
            });
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_in_loan, parent, false);
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
        void onItemClick(Item_in_loan item);
    }
}