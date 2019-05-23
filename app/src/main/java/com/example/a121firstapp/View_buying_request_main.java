package com.example.a121firstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.a121firstapp.Class_Adapter.GridViewAdapter;
import com.example.a121firstapp.Class_Adapter.ListViewAdapter;
import com.example.a121firstapp.Class_item.Article;

import java.util.ArrayList;
import java.util.List;


public class View_buying_request_main extends AppCompatActivity {

    public ViewStub stubGrid;
    public ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private ArrayList<Article> articleList;
    public int currentViewMode = 0;
    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;
    private Menu menu;
    private String keyword;
    private ArrayList<Article> search_result_arraylist;
    private MenuItem mSearchMenuItem;
    Button button1, button2;

    Toolbar toolbar;

//    private ListView mListView;
//    private GridView mGridView;
//    private ArrayAdapter aAdapter;

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_view_buying_request);
        setTitle("Mortorbike");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(View_buying_request_main.this, "back!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        initToolBar();

        ImageButton imageButton = (ImageButton) findViewById(R.id.ibtSwap);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(View_buying_request_main.this, "Swap", Toast.LENGTH_SHORT).show();
                if (VIEW_MODE_LISTVIEW == currentViewMode) {
                    //item.setIcon(getResources().getDrawable(R.drawable.ic_view_list));
                    currentViewMode = VIEW_MODE_GRIDVIEW;
                } else {
                    //item.setIcon(getResources().getDrawable(R.drawable.ic_view_grid));
                    currentViewMode = VIEW_MODE_LISTVIEW;
                }

                switchView();
                SharedPreferences sharedPreferences = v.getContext().getSharedPreferences("ViewMode", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();
            }
        });

        Button btnHonda = (Button)findViewById(R.id.btnHondaList);
        btnHonda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(View_buying_request_main.this,"Honda Lists", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnYamaha = (Button)findViewById(R.id.btnYamahaList);
        btnYamaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(View_buying_request_main.this,"Yamaha Lists", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSuzuki = (Button)findViewById(R.id.btnSuzukiList);
        btnSuzuki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(View_buying_request_main.this,"Suzuki Lists", Toast.LENGTH_SHORT).show();
            }
        });

        button1 = (Button)findViewById(R.id.btnSort);
        button2 = (Button)findViewById(R.id.btnFilter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu1 = new PopupMenu(View_buying_request_main.this,button1);
                popupMenu1.getMenuInflater().inflate(R.menu.popup_sort, popupMenu1.getMenu());

                popupMenu1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item1) {
                        Toast.makeText(View_buying_request_main.this,"" + item1.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu1.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu2 = new PopupMenu(View_buying_request_main.this,button2);
                popupMenu2.getMenuInflater().inflate(R.menu.popup_filter, popupMenu2.getMenu());

                popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item2) {
                        Toast.makeText(View_buying_request_main.this,"" + item2.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu2.show();
            }
        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        stubGrid = (ViewStub) findViewById(R.id.stub_grid);
        stubList = (ViewStub) findViewById(R.id.stub_list);

        stubGrid.inflate();
        stubList.inflate();

        listView = (ListView) findViewById(R.id.mylistview);
        gridView = (GridView) findViewById(R.id.mygridview);

        //Get list for articles
        getArticleList();

        //Get current view mode in share reference
        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", Context.MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currenteViewMode", VIEW_MODE_LISTVIEW);

        switchView();

        final ListView lv = (ListView) findViewById(R.id.mylistview);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Article article = (Article)lv.getItemAtPosition(position);
                Toast.makeText(View_buying_request_main.this,"" + ""+article.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void switchView() {
        if (VIEW_MODE_LISTVIEW == currentViewMode) {
            stubList.setVisibility(View.VISIBLE);
            stubGrid.setVisibility(View.GONE);
        } else {
            stubList.setVisibility(View.GONE);
            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapters();
    }

    public void setAdapters() {

        if (VIEW_MODE_LISTVIEW == currentViewMode) {
            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, articleList);
            listViewAdapter.notifyDataSetChanged();
            listView.setAdapter(listViewAdapter);
        } else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, articleList);
            gridViewAdapter.notifyDataSetChanged();
            gridView.setAdapter(gridViewAdapter);
        }

    }

    public List<Article> getArticleList() {
        articleList = new ArrayList<>();
        articleList.add(new Article(0, "Click 2019", "Posted: 22 hrs ago", R.drawable.click_2019, "2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        articleList.add(new Article(1, "Dream Red New", "Posted: 22 hrs ago", R.drawable.dream_red,"2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        articleList.add(new Article(2, "Duke C390 2019", "Posted: 22 hrs ago", R.drawable.duke_c390_2019,"2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        articleList.add(new Article(3, "Fino New 2019", "Posted: 22 hrs ago", R.drawable.fino_2019,"2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        articleList.add(new Article(4, "Dream Gold New", "Posted: 22 hrs ago", R.drawable.gold_dream,"2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        articleList.add(new Article(5, "GSX250OR SUZUKI ", "Posted: 22 hrs ago", R.drawable.gsx250or,"2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        articleList.add(new Article(6, "MSX New 2019", "Posted: 22 hrs ago", R.drawable.msx_2019,"2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        articleList.add(new Article(7, "PCX 2019", "Posted: 22 hrs ago", R.drawable.pcx_2019,"2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        articleList.add(new Article(8, "Roll Royce 2019", "Posted: 22 hrs ago", R.drawable.roll_royce_2019,"2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        articleList.add(new Article(9, "Scoopy New 2019", "Posted: 22 hrs ago", R.drawable.scopy_2019,"2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        articleList.add(new Article(10, "Zoomer X 2019", "Posted: 22 hrs ago", R.drawable.zoomer_x,"2250 $", "Color: WHITE","Brand: HONDA", "Category: Motorbike", "2019"));
        return articleList;


    }


//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_and_shop, menu);
        MenuItem search_item = menu.findItem(R.id.action_search);
        MenuItem shop_item = menu.findItem(R.id.action_Shop);

        SearchView searchView = (SearchView) search_item.getActionView();
        searchView.setFocusable(false);
        searchView.setQueryHint("Search");
//        search_item.expandActionView();

        //search items
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                if (VIEW_MODE_LISTVIEW == currentViewMode) {
                    listViewAdapter.getFilter().filter(s);
                } else {
                    gridViewAdapter.getFilter().filter(s);
                }
                return false;
            }
        });

        shop_item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(View_buying_request_main.this,"Shop View",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        //Hide action_list whene searchview is expanded
//        search_item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
//
//            @Override
//            public boolean onMenuItemActionExpand(MenuItem item) {
//                if (menu != null) {
//                    menu.findItem(R.id.action_list).setVisible(false);
//                }
//                return true; // KEEP IT TO TRUE OR IT DOESN'T OPEN !!
//            }
//
//            @Override
//            public boolean onMenuItemActionCollapse(MenuItem item) {
//                if (menu != null) {
//                    menu.findItem(R.id.action_list).setVisible(true);
//                }
//                return true; // OR FALSE IF YOU DIDN'T WANT IT TO CLOSE!
//            }
//        });

        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        switch (item.getItemId()) {
//            case R.id.action_list:
//                if (VIEW_MODE_LISTVIEW == currentViewMode) {
//                    item.setIcon(getResources().getDrawable(R.drawable.ic_view_list));
//                    currentViewMode = VIEW_MODE_GRIDVIEW;
//                } else {
//                    item.setIcon(getResources().getDrawable(R.drawable.ic_view_grid));
//                    currentViewMode = VIEW_MODE_LISTVIEW;
//                }
//
//                switchView();
//                SharedPreferences sharedPreferences = this.getSharedPreferences("ViewMode", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putInt("currentViewMode", currentViewMode);
//                editor.commit();
//                break;
//        }
//        return false;
//    }

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
