package com.example.a121firstapp;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
    ImageView img_type_acc,img_name_acc,img_gender,img_dob,img_pob,img_marital,img_wing_num,img_phone1,img_phone2,img_phone3;
    EditText edit_type,edit_name_acc,edit_gender,edit_dob,edit_pob,edit_marital,edit_wing_num,edit_phone1,edit_phone2,edit_phone3;
    TextView txt_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_account);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_edit);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.icon_back_30px);
        setSupportActionBar(toolbar);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent));

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
        edit_type = (EditText) findViewById(R.id.edit_fname);
        img_type_acc = (ImageView)findViewById(R.id.img_fimage);
        edit_type.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_type_acc.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_type_acc.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_type_acc.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_name_acc = (EditText)findViewById(R.id.edit_lname);
        img_name_acc = (ImageView)findViewById(R.id.img_limage);
        edit_name_acc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_name_acc.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_name_acc.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_name_acc.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_gender = (EditText)findViewById(R.id.edit_lstore);
        img_gender = (ImageView)findViewById(R.id.img_store);
        edit_gender.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_gender.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_gender.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_gender.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_dob = (EditText)findViewById(R.id.edit_lb_shop);
        img_dob = (ImageView)findViewById(R.id.img_lb_shop);
        edit_dob.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_dob.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_dob.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_dob.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_pob = (EditText)findViewById(R.id.edit_wingnumber);
        img_pob = (ImageView)findViewById(R.id.img_wingnumber);
        edit_pob.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_pob.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<8 || s.length()>8)
                    img_pob.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_pob.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_marital = (EditText)findViewById(R.id.edit_wingname);
        img_marital = (ImageView)findViewById(R.id.img_wingname);
        edit_marital.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_marital.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_marital.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_marital.setImageResource(R.drawable.icon_ok_24px);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edit_wing_num = (EditText)findViewById(R.id.edit_dealer);
        img_wing_num = (ImageView)findViewById(R.id.img_dealer);
        edit_wing_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    img_wing_num.setImageResource(R.drawable.icon_circle_null_24);
                else if (s.length()<3)
                    img_wing_num.setImageResource(R.drawable.ic_error_black_24dp);
                else
                    img_wing_num.setImageResource(R.drawable.icon_ok_24px);
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
