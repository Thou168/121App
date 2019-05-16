package com.example.a121firstapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public BottomNavigationView bottomNavigationView;
    String currentLanguage = "km", currentLang;
    Bundle args;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        //   getSupportFragmentManager().beginTransaction().replace(R.id.fragme_container,new fram_home()).commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        //   bottomNavigationView.setSelectedItemId(Integer.parseInt(getIntent().getStringExtra("ac")));

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new fram_home();
                            selectedFragment.setArguments(args);
                            break;
                        case R.id.nav_notification:
                            selectedFragment = new fram_notification();
                            break;
                        case R.id.nav_camera:
                            selectedFragment = new fram_camera();
//                            bottomNavigationView.setVisibility(View.GONE);
                            break;
                        case R.id.nav_sms:
                            selectedFragment = new fram_message();
                            break;
                        case R.id.nav_account:
                            selectedFragment = new fram_account();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectedFragment).commit();
                    return true;
                }
            };
}
