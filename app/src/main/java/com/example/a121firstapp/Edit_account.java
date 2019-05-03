package com.example.a121firstapp;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Edit_account extends AppCompatActivity  implements OnMapReadyCallback {

    TextInputLayout phone2,phone3;
    Button btn_one,btn_two;
    ImageView img1;
    ImageView img_fname,img_lname,img_store,img_bc,img_wingnum,img_wingname,img_dealer,img_phone1,img_phone2,img_phone3;
    EditText edit_fname,edit_lname,edit_store,edit_bc,edit_wingnum,edit_wingname,edit_dealer,edit_phone1,edit_phone2,edit_phone3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_account);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_edit);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.icon_back_30px);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        img1 = (ImageView)findViewById(R.id.img_three);

        phone2=(TextInputLayout)findViewById(R.id.num_two);
        phone2.setVisibility(View.GONE);
        phone3=(TextInputLayout)findViewById(R.id.num_three);
        phone3.setVisibility(View.GONE);

        btn_one = (Button)findViewById(R.id.btn_one);
        btn_one.setEnabled(false);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone2.setVisibility(View.VISIBLE);
                btn_one.setVisibility(View.GONE);
            }
        });
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setEnabled(false);
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone3.setVisibility(View.VISIBLE);
                btn_two.setVisibility(View.GONE);
            }
        });
        comf();

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng PhnomPenh = new LatLng(11.584830, 104.868699);
        googleMap.addMarker(new MarkerOptions().position(PhnomPenh).title("Phnom Penh"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(PhnomPenh));
    }
    public void comf(){
        edit_fname = (EditText)findViewById(R.id.edit_fname);
        img_fname = (ImageView)findViewById(R.id.img_fimage);
        edit_fname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_fname.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_fname.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_fname.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_lname = (EditText)findViewById(R.id.edit_lname);
        img_lname = (ImageView)findViewById(R.id.img_limage);
        edit_lname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_lname.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_lname.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_lname.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_store = (EditText)findViewById(R.id.edit_lstore);
        img_store = (ImageView)findViewById(R.id.img_store);
        edit_store.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_store.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_store.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_store.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_bc = (EditText)findViewById(R.id.edit_lb_shop);
        img_bc = (ImageView)findViewById(R.id.img_lb_shop);
        edit_bc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_bc.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_bc.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_bc.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_wingnum = (EditText)findViewById(R.id.edit_wingnumber);
        img_wingnum = (ImageView)findViewById(R.id.img_wingnumber);
        edit_wingnum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_wingnum.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<8 || s.length()>8)
                    img_wingnum.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_wingnum.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_wingname = (EditText)findViewById(R.id.edit_wingname);
        img_wingname = (ImageView)findViewById(R.id.img_wingname);
        edit_wingname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_wingname.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_wingname.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_wingname.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_dealer = (EditText)findViewById(R.id.edit_dealer);
        img_dealer = (ImageView)findViewById(R.id.img_dealer);
        edit_dealer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_dealer.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_dealer.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_dealer.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_phone1 = (EditText)findViewById(R.id.edit_numone);
        img_phone1 = (ImageView)findViewById(R.id.img_numone);
        edit_phone1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0) {
                    img_phone1.setImageResource(R.drawable.icon_circle_null_24);
                }
                else if (s.length()<9 || s.length()>10) {
                    img_phone1.setImageResource(R.drawable.ic_error_black_24dp);
                    btn_one.setEnabled(false);
                }
                else {
                    img_phone1.setImageResource(R.drawable.icon_ok_24px);
                    btn_one.setEnabled(true);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_phone2 = (EditText)findViewById(R.id.edit_numtwo);
        img_phone2 = (ImageView)findViewById(R.id.img_numtwo);
        edit_phone2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0) {
                    img_phone2.setImageResource(R.drawable.icon_circle_null_24);
                }
                else if (s.length()<9 || s.length()>10) {
                    img_phone2.setImageResource(R.drawable.ic_error_black_24dp);
                    btn_two.setEnabled(false);
                }
                else {
                    img_phone2.setImageResource(R.drawable.icon_ok_24px);
                    btn_two.setEnabled(true);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_phone3 = (EditText)findViewById(R.id.edit_three);
        img_phone3 = (ImageView)findViewById(R.id.img_three);
        edit_phone3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0) {
                    img_phone3.setImageResource(R.drawable.icon_circle_null_24);
                }
                else if (s.length()<9 || s.length()>10)
                    img_phone3.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_phone3.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
