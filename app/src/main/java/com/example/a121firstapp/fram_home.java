package com.example.a121firstapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a121firstapp.Class_Adapter.ItemClickListener;
import com.example.a121firstapp.Class_Adapter.Vertical;
import com.example.a121firstapp.Class_item.Item_vertical;
import com.example.a121firstapp.Class_item.Item_horizotal;
import com.example.a121firstapp.Class_Adapter.Horizontal;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class fram_home extends Fragment implements NavigationView.OnNavigationItemSelectedListener,
        Vertical.ItemListener {

    Locale myLocale;
    String currentLanguage = "en", currentLang;
    int khmer,english=R.drawable.flag_english;
    TextView tvbuy,tvsell,tvrent,tvdic,tvnew;
    Toolbar toolbar;
    DrawerLayout drawer;
    Spinner sp_breand,sp_price,sp_loca;
    private ArrayList<Item_horizotal> items;
    private ArrayList<Item_vertical> item;
    private LinearLayout mLinearLayout;
    EditText edtsearch;
    Button btn_breand,btn_price,btn_loca,btn_insert,btn_language;
    RecyclerView recy_vertical;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fram_home, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar_home);
        toolbar.setTitle("");
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
//slider
        BannerSlider slider = (BannerSlider) view.findViewById(R.id.bannerSlider);
        List<Banner> banners=new ArrayList<>();
        //add banner using image url
        banners.add(new RemoteBanner("https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg"));
        banners.add(new RemoteBanner("https://assets.materialup.com/uploads/20ded50d-cc85-4e72-9ce3-452671cf7a6d/preview.jpg"));
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.image_slider_1));
        slider.setBanners(banners);

        currentLanguage = getActivity().getIntent().getStringExtra(currentLang);
        khmer = getActivity().getIntent().getIntExtra("khmer",R.drawable.flag_english);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = database.getReference("Product");

        tvbuy = (TextView)view.findViewById(R.id.txtbuy);
        tvsell = (TextView)view.findViewById(R.id.txtsell);
        tvrent = (TextView)view.findViewById(R.id.txtrent);
        tvdic = (TextView)view.findViewById(R.id.product_dic);
        tvnew = (TextView)view.findViewById(R.id.new_post);

        btn_language = (Button)view.findViewById(R.id.btn_language);
        btn_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("km");

            }
        });
        btn_language.setBackgroundResource(khmer);
        /*
        btn_insert = (Button) view.findViewById(R.id.insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Insertdata.class);
                startActivity(intent);
            }
        });
        */
        edtsearch = (EditText) view.findViewById(R.id.edt_search);
        edtsearch.setSelected(false);

        drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //dropdwon
        /*
        sp_breand = (Spinner) view.findViewById(R.id.sp_brand);
        String[] st_brand =getResources().getStringArray(R.array.sp_brand);
        ArrayAdapter<String> ad_brand= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, st_brand);
        ad_brand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_breand.setAdapter(ad_brand);

        sp_price = (Spinner)view.findViewById(R.id.sp_price);
        String[] st_price =getResources().getStringArray(R.array.sp_price);
        ArrayAdapter<String> ad_price= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, st_price);
        ad_price.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_price.setAdapter(ad_price);

        sp_loca = (Spinner)view.findViewById(R.id.sp_location);
        String[] countries=getResources().getStringArray(R.array.sp_location);
        ArrayAdapter<String> gameKindArray= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, countries);
        gameKindArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_loca.setAdapter(gameKindArray);
        */
//Horizontal
        ItemHorizontal();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        Horizontal adapter = new Horizontal(getContext(),items);
        RecyclerView recy_horizontal = (RecyclerView) view.findViewById(R.id.recy_horizontal);
        recy_horizontal.setHasFixedSize(true);
        recy_horizontal.setLayoutManager(layoutManager);
        recy_horizontal.setAdapter(adapter);
//Vertical
       ItemVertical();
        recy_vertical = (RecyclerView) view.findViewById(R.id.recy_vertical);
        recy_vertical.setHasFixedSize(true);
        recy_vertical.setNestedScrollingEnabled(false);
        Vertical adapter1 = new Vertical(getContext(), item, this);
        recy_vertical.setAdapter(adapter1);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recy_vertical.setLayoutManager(manager);

        /*
        FirebaseRecyclerAdapter<Item_product,MovieViewHolder> adapter1 = new FirebaseRecyclerAdapter<Item_product, MovieViewHolder>(Item_product.class,
                R.layout.image_product,MovieViewHolder.class,table) {
            @Override
            protected void populateViewHolder(MovieViewHolder viewHolder, final Item_product model, int position) {
                viewHolder.tvName.setText(model.getName());
                viewHolder.tvprice.setText(model.getPrice());
                Picasso.with(getContext()).load(model.getImage()).into(viewHolder.ivproduct);
                final Item_product clickitem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void OnClick(View view, int position, Boolean isLongClick) {
                        Toast.makeText(getContext(),""+model.getName(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };

        recy_vertical.setAdapter(adapter1);
        */

        return view;
    }


    private void ItemVertical(){
        item = new ArrayList<>();
        item.add( new Item_vertical(R.drawable.image_zoomer_x_2017,"Zoomer X 2017",2050));
        item.add( new Item_vertical(R.drawable.image_honda_dream,"Honda Dream c125",2000));
        item.add( new Item_vertical(R.drawable.image_honda_click125i_19,"Click 2019",1900));
        item.add( new Item_vertical(R.drawable.image_zoomer_x_2017,"Zoomer X 2017",2050));
        item.add( new Item_vertical(R.drawable.image_macbook_pro_2018,"MacbookPro 2018",2300));
        item.add( new Item_vertical(R.drawable.image_nex,"Nex 2019",1800));
        item.add( new Item_vertical(R.drawable.image_hybrid_2017,"Honda Hybrid 2017",35000));
    }
    private void ItemHorizontal(){
        items = new ArrayList<>();
        items.add( new Item_horizotal(R.drawable.image_zoomer_x_2017,"Zoomer X 2017",2050,1590));
        items.add( new Item_horizotal(R.drawable.image_honda_dream,"Honda Dream c125",2000,1800));
        items.add( new Item_horizotal(R.drawable.image_honda_click125i_19,"Click 2019",1900,1660));
        items.add( new Item_horizotal(R.drawable.image_zoomer_x_2017,"Zoomer X 2017",2050,1590));
        items.add( new Item_horizotal(R.drawable.image_macbook_pro_2018,"Macbook Pro 2018",2300,1700));
        items.add( new Item_horizotal(R.drawable.image_nex,"Nex 2019",1800,1000));
        items.add( new Item_horizotal(R.drawable.image_hybrid_2017,"Honda Hybrid 2017",35000,3000));
    }

    Fragment fragment;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id){
            case R.id.nav_profile:
                Intent intent = new Intent(getContext(),Edit_account.class);
                startActivity(intent);
                return true;
            case R.id.nav_your_post:

//                Fragment someFragment = new fram_account();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.frameLayout, someFragment );
//                transaction.addToBackStack(null);
//                transaction.commit();

                return true;
            case R.id.nav_your_like:
                Toast.makeText(getContext(),"Your Like",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_loan:
                Toast.makeText(getContext(),"Your Loan",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_product_order:
                Toast.makeText(getContext(),"Your Product Order",Toast.LENGTH_SHORT).show();
                return true;
                /*
            case R.id.nav_report:
                Toast.makeText(getContext(),"Report",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_language:
                Toast.makeText(getContext(),"Language",Toast.LENGTH_SHORT).show();
                return true;
                */
        }
        DrawerLayout drawer = (DrawerLayout) getView().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    public void setLocale(String lang) {
        if (!lang.equals(currentLanguage)) {
            myLocale = new Locale(lang);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(getContext(), MainActivity.class);
            refresh.putExtra(currentLang, lang);
            refresh.putExtra("khmer",R.drawable.flag_khmer);
            startActivity(refresh);
        }
        else {
            myLocale = new Locale("en");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(getContext(), MainActivity.class);
            refresh.putExtra(currentLang, "en");
            refresh.putExtra("khmer",R.drawable.flag_english);
            startActivity(refresh);
        }

    }

    @Override
    public void onItemClick(Item_vertical item) {
     //   Toast.makeText(getContext(), item.getBrand() + " is clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(),View_buying_request_item_detail.class);
        intent.putExtra("img_header",item.getImage_view());
        intent.putExtra("brand",item.getBrand());
        intent.putExtra("price",item.getPrice());
        startActivity(intent);
    }
    //PopupMenu

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvName,tvprice;
        ImageView ivproduct;
        private ItemClickListener itemClickListener;
        public MovieViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.tv_name);
            tvprice = (TextView) v.findViewById(R.id.tv_price);
            ivproduct = (ImageView) v.findViewById(R.id.iv_product);
            v.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.OnClick(v,getAdapterPosition(),false);
        }
    }
}