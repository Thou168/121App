package com.example.a121firstapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public BottomNavigationView bottomNavigationView;
    String currentLanguage = "km", currentLang;
    Bundle args;
    SharedPreferences prefer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefer = getSharedPreferences("Register",MODE_PRIVATE);


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
                            if (prefer.contains("token")){

                                selectedFragment = new fram_account();

                            }else {
                                selectedFragment = new fram_account();
                                Intent intent = new Intent(MainActivity.this,UserAccountRegisterFacebookActivity.class);
                                startActivity(intent);
                            }

                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectedFragment).commit();
                    return true;
                }
            };
}
