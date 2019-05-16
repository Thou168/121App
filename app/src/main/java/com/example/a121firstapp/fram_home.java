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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a121firstapp.Class_Adapter.ItemClickListener;
import com.example.a121firstapp.Class_Adapter.Vertical;
import com.example.a121firstapp.Class_item.Item_vertical;
import com.example.a121firstapp.Class_item.Item_horizotal;
import com.example.a121firstapp.Class_Adapter.Horizontal;
import com.example.a121firstapp._sliders.FragmentSlider;
import com.example.a121firstapp._sliders.SliderIndicator;
import com.example.a121firstapp._sliders.SliderPagerAdapter;
import com.example.a121firstapp._sliders.SliderView;
/*
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class fram_home extends Fragment implements NavigationView.OnNavigationItemSelectedListener,
        Vertical.ItemListener,PopupMenu.OnMenuItemClickListener  {

    Toolbar toolbar;
    DrawerLayout drawer;
    Spinner sp_breand,sp_price,sp_loca;
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private ArrayList<Item_horizotal> items;
    private ArrayList<Item_vertical> item;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    EditText edtsearch;
    Button btn_breand,btn_price,btn_loca,btn_insert;
    RecyclerView recy_vertical;

    Locale myLocale;
    String currentLanguage = "km", currentLang;
    //private final String LOG_TAG=getActivity().getClass().getSimpleName();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fram_home, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar_home);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        /*
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = database.getReference("Product");

        btn_insert = (Button) view.findViewById(R.id.insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Insertdata.class);
                startActivity(intent);
            }
        });
        */

        if(getArguments()!=null){
            currentLanguage =getArguments().getString(currentLang);
        }
        String LOG_TAG=getContext().getClass().getSimpleName();


        edtsearch = (EditText) view.findViewById(R.id.edt_search);
        edtsearch.setSelected(false);

        drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //sliderview
        sliderView = (SliderView) view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        setupSlider();
        //dropdwon
        /*
        btn_breand = (Button) view.findViewById(R.id.btnShow);
        btn_breand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getContext(), v);
                popup.setOnMenuItemClickListener(fram_home.this);
                popup.inflate(R.menu.popup_breand);
                popup.show();
            }
        });
        btn_price = (Button) view.findViewById(R.id.btn_price);
        btn_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getContext(), v);
                popup.setOnMenuItemClickListener(fram_home.this);
                popup.inflate(R.menu.popup_price);
                popup.show();
            }
        });
        btn_loca = (Button) view.findViewById(R.id.btn_location);
        btn_loca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getContext(), v);
                popup.setOnMenuItemClickListener(fram_home.this);
                popup.inflate(R.menu.popup_location);
                popup.show();
            }
        });
        */
        //Horizontal
        ItemHorizontal();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        Horizontal adapter = new Horizontal(getContext(),items);
        RecyclerView recy_horizontal = (RecyclerView) view.findViewById(R.id.recy_horizontal);
        recy_horizontal.setHasFixedSize(true);
        recy_horizontal.setLayoutManager(layoutManager);
        recy_horizontal.setAdapter(adapter);
        //        //Vertical
        ItemVertical();
        recy_vertical = (RecyclerView) view.findViewById(R.id.recy_vertical);
        Vertical adapter1 = new Vertical(getContext(), item, this);
        recy_vertical.setAdapter(adapter1);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recy_vertical.setLayoutManager(manager);
        recy_vertical.setHasFixedSize(true);
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
        item.add( new Item_vertical(R.drawable.image_zoomer_x_2017,"Zoomer X 2017",2050,"Phnom Penh"));
        item.add( new Item_vertical(R.drawable.image_honda_dream,"Honda Dream c125",2000,"Phnom Penh"));
        item.add( new Item_vertical(R.drawable.image_honda_click125i_19,"Click 2019",1900,"Phnom Penh"));
        item.add( new Item_vertical(R.drawable.image_zoomer_x_2017,"Zoomer X 2017",2050,"Phnom Penh"));
        item.add( new Item_vertical(R.drawable.image_macbook_pro_2018,"Macbook Pro 2018",2300,"Phnom Penh"));
        item.add( new Item_vertical(R.drawable.image_nex,"Nex 2019",1800,"Phnom Penh"));
        item.add( new Item_vertical(R.drawable.image_hybrid_2017,"Honda Hybrid 2017",35000,"Phnom Penh"));
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
    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));
        //getActivity().getSupportFragmentManager()
        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getContext(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
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

        }
        DrawerLayout drawer = (DrawerLayout) getView().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_page_item,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
//change language
    boolean click = true;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_khmer:
                if(click){
                    item.setIcon(R.drawable.flag_english);
                    setLocale("en");
                    click = false;
                }
                else {
                    item.setIcon(R.drawable.flag_khmer);
                    setLocale("km");
                    click = true;
                }
                break;
        }
        return super.onOptionsItemSelected(item);
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
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(getContext(), "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.honda:
                // do your code
                btn_breand.setText(item.getTitle());
                return true;
            case R.id.yamaha:
                // do your code
                btn_breand.setText(item.getTitle());
                return true;
            case R.id.suzuki:
                // do your code
                btn_breand.setText(item.getTitle());
                return true;
            case R.id.kawasaki:
                // do your code
                btn_breand.setText(item.getTitle());
                return true;
 //Price
            case R.id.one:
                // do your code
                btn_price.setText(item.getTitle());
                return true;
            case R.id.two:
                // do your code
                btn_price.setText(item.getTitle());
                return true;
            case R.id.three:
                // do your code
                btn_price.setText(item.getTitle());
                return true;
            case R.id.four:
                // do your code
                btn_price.setText(item.getTitle());
                return true;
//Location
            case R.id.pp:
                btn_loca.setText(item.getTitle());
                return true;
            case R.id.kpc:
                btn_loca.setText(item.getTitle());
                return true;
            case R.id.kpt:
                btn_loca.setText(item.getTitle());
                return true;
            default:
                return false;
        }
    }
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
    public void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            //Intent refresh = new Intent(this.getContext(), MainActivity.class);
            //refresh.putExtra(currentLang, localeName);
            //startActivity(refresh);
            //getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        } else {

        }
    }
}