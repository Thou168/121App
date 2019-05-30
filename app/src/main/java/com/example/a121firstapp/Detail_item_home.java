package com.example.a121firstapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.List;

import ss.com.bannerslider.views.BannerSlider;

public class Detail_item_home extends AppCompatActivity {

    String[] title_product_moto, post, amount;
    TextView tax, brand, year, condition, price;

    List<Integer> image;
    TabLayout indicator;
    BannerSlider bannerSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_product_item_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.icon_back_30px);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bannerSlider = (BannerSlider)findViewById(R.id.bannerSlider);
    }
}

