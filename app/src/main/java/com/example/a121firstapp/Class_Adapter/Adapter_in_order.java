package com.example.a121firstapp.Class_Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a121firstapp.Class_item.Item_order_list;
import com.example.a121firstapp.R;

import java.util.ArrayList;

/*
 * Created by Sambhaji Karad on 04-Jan-18
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

public class Adapter_in_order extends RecyclerView.Adapter<Adapter_in_order.ViewHolder> {

    private ArrayList<Item_order_list> mValues;
    private Context mContext;
    protected ItemListener mListener;

    RelativeLayout relativeLayout;
    public Adapter_in_order(Context context, ArrayList<Item_order_list> values, ItemListener itemListener) {
        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtbreand,txtprice,txtcondition,txtamount;
        private ImageView imageView;
        private ImageButton btn_showdetail;
        private Item_order_list items;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            imageView = (ImageView) v.findViewById(R.id.image_product);
            txtbreand = (TextView) v.findViewById(R.id.txt_title);
            txtprice = (TextView) v.findViewById(R.id.txt_Price);
            txtcondition = (TextView) v.findViewById(R.id.txt_condition);
            txtamount = (TextView) v.findViewById(R.id.txt_amount_request);
            btn_showdetail = (ImageButton) v.findViewById(R.id.btnShowDetail);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);
        }

        public void setData(final Item_order_list item) {
            this.items = item;
            imageView.setImageResource(item.getImg_view());
            txtbreand.setText(item.getBrand());
            txtprice.setText(Double.toString(item.getPrice()));
            txtcondition.setText(item.getCondition());
            txtamount.setText(Double.toString(item.getAmt_request()));
        //    txtprice.setText(Double.toString(item.getPrice()));
            //relativeLayout.setBackgroundColor(Color.parseColor(item.color));

            btn_showdetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Detail  "+item.getBrand(),Toast.LENGTH_LONG).show();
                }
            });

            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Context context = v.getContext();
                    final BottomSheetDialog dialog;
                    View view=LayoutInflater.from(context).inflate(R.layout.dialog_approve_reject,null);
                    dialog= new BottomSheetDialog(context);
                    dialog.setCancelable(true);
                    dialog.setCanceledOnTouchOutside(true);
                    dialog.setContentView(view);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                    dialog.findViewById(R.id.btnApprove).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new AlertDialog.Builder(context).setMessage("The Product Posting has been Approve").setCancelable(false)
                                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    }).show();
                            dialog.dismiss();

                        }
                    });

                    dialog.findViewById(R.id.btnReject).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new AlertDialog.Builder(context).setMessage("The Product Posting has been Reject").setCancelable(false)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    }).show();
                            dialog.dismiss();
                        }
                    });

                    dialog.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                }
            });
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(items);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_in_order, parent, false);
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
        void onItemClick(Item_order_list item);
    }
}