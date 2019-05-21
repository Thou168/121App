package com.example.a121firstapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class View_buying_request_item_detail extends AppCompatActivity {

    String[] kh_title,detail;
    ImageView imageView;
    TextView breand,price;
    Button btn_call,btn_chat,btn_order,btn_loan, phone1,phone2,cancel;
    BottomSheetDialog bottomSheetDialog;
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_buying_request_item_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.icon_back_30px);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

// action button

        btn_call = (Button)findViewById(R.id.btn_call);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               bottomsheet(v);
                phone1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String num = phone1.getText().toString();
                        makePhonecall(num);
                        bottomSheetDialog.dismiss();
                    }
                });
                phone2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String num = phone2.getText().toString();
                        makePhonecall(num);
                        bottomSheetDialog.dismiss();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        btn_chat = (Button)findViewById(R.id.btn_chat);
        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomsheet(v);

                phone1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sms = phone1.getText().toString();
                        makeSMS(sms);
                        bottomSheetDialog.dismiss();
                    }
                });

                phone2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sms = phone2.getText().toString();
                        makeSMS(sms);
                        bottomSheetDialog.dismiss();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        btn_order = (Button)findViewById(R.id.btn_order);
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(v.getContext(),MainActivity.class);
                //  intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                AlertDialog.Builder alert = new AlertDialog.Builder(View_buying_request_item_detail.this);
                alert.setTitle("List order");
                alert.setMessage("Order Completed");
                alert.setPositiveButton("OK",null);
                alert.show();
                // v.getContext().startActivity(intent);
            }
        });

        btn_loan = (Button)findViewById(R.id.btn_loan);
        btn_loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"loan",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),create_loan_request.class);
                startActivity(intent);
            }
        });

/// finish buttom

        imageView = (ImageView)findViewById(R.id.image_header);
        imageView.setImageResource(getIntent().getIntExtra("img_header",0));
        breand = (TextView)findViewById(R.id.name_product);
        breand.setText(getIntent().getStringExtra("brand"));
        price = (TextView)findViewById(R.id.name_price);
        price.setText(Double.toString(getIntent().getDoubleExtra("price",1)));

        kh_title = getResources().getStringArray(R.array.kh_title);
        detail = new String[]{
                String.valueOf(Double.toString(getIntent().getDoubleExtra("price",1))),
                String.valueOf(getIntent().getStringExtra("brand")),
                String.valueOf("2019"),
                String.valueOf("Good")
        };
        final List<HashMap<String,String>> alist = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<4;i++){
            HashMap<String,String> hm = new HashMap<String, String>();
            hm.put("listview_title",kh_title[i]);
            hm.put("brand",detail[i]);
            alist.add(hm);
        }
        String[] from = {"listview_title","brand"};
        int[] to = {R.id.listview_item_title,R.id.listview_item_show};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), alist, R.layout.single_row, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_product, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void bottomsheet(View v){
        View view = LayoutInflater.from(v.getContext()).inflate(R.layout.bottom_sheet_call,null);
        phone1 = view.findViewById(R.id.btnPhone1);
        phone2 = view.findViewById(R.id.btnPhone2);
        cancel = view.findViewById(R.id.btnCancel);

        bottomSheetDialog = new BottomSheetDialog(v.getContext());
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bottomSheetDialog.show();
    }

    public void makeSMS(String sms){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",sms,null));
        startActivity(intent);
    }
    public void makePhonecall(String num){

        if (ContextCompat.checkSelfPermission(View_buying_request_item_detail.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(View_buying_request_item_detail.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else {
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ num)));
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, @NonNull int[] grantResults ) {
        if (requestCode == REQUEST_CALL){
            if (grantResults.length > 0 &&   grantResults[0]  == PackageManager.PERMISSION_GRANTED){
                //  makePhonecall(num);
            }
        }
    }

    boolean click = true;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_heart:
                if(click){
                    item.setIcon(R.drawable.icon_heart_30px1);
                    click = false;
                }
                else {
                    item.setIcon(R.drawable.icon_heart_30px);
                    click = true;
                }
                break;
            case R.id.action_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String ShareSubject = ("Your Subject here");
                intent.putExtra(Intent.EXTRA_SUBJECT,ShareSubject);
                startActivity(Intent.createChooser(intent,"share_using"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
