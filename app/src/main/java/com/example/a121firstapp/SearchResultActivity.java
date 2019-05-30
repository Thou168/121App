package com.example.a121firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class SearchResultActivity extends AppCompatActivity  {

    MaterialSearchView searchView = null;
    String[] list_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_result_search);
        setActionBar(toolbar);

        list_result = new String[]{"Apple","Pine Apple","Orange","Mango","Coconut","Carrot"};

        searchView = (MaterialSearchView)findViewById(R.id.result_search);
        searchView.closeSearch();
        searchView.setSuggestions(list_result);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.result_search,menu);

        MenuItem item = menu.findItem(R.id.menu_search_result);
        searchView.setMenuItem(item);
        return true;
    }
}
