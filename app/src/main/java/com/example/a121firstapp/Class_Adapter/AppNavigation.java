package com.example.a121firstapp.Class_Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.a121firstapp.Edit_account;
import com.example.a121firstapp.R;
import com.example.a121firstapp.fram_home;
import com.example.a121firstapp.fram_notification;

public class AppNavigation {

    public static void setupDrawerContent(final Context context, NavigationView navigationView, final DrawerLayout mDrawer, final FragmentActivity activity){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectDrawerItem(context,menuItem,mDrawer,activity);
                return true;
            }
        });
    }

    public static void selectDrawerItem(Context context, MenuItem menuItem,DrawerLayout mDrawer,FragmentActivity activity){
        Fragment fragment=null;
        Class fragementClass;
        String notificationType="";
        switch (menuItem.getItemId()){
            case R.id.nav_profile:
                fragementClass=null;
                Intent intent = new Intent(context, Edit_account.class);
                context.startActivity(intent);
                break;
            case R.id.nav_your_post:
                fragementClass= fram_notification.class;
                notificationType="post";
                break;
            case R.id.nav_your_like:
                Toast.makeText(context,"Your Like",Toast.LENGTH_SHORT).show();
                fragementClass=null;
                break;
            case R.id.nav_loan:
                fragementClass=fram_notification.class;
                notificationType="loan";
                break;
            case  R.id.nav_product_order:
                fragementClass=fram_notification.class;
                notificationType="order";
                break;
                /*
            case R.id.nav_report:
                fragementClass=null;
                Toast.makeText(context,"Report",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_language:
                fragementClass=null;
                Toast.makeText(context,"Language",Toast.LENGTH_SHORT).show();
                break;
                */
            default:
                fragementClass= fram_home.class;
        }
        try{
            Bundle bundle=new Bundle();
            bundle.putString("type",notificationType);
            fragment=(Fragment) fragementClass.newInstance();
            fragment.setArguments(bundle);
            FragmentManager fragmentManager=activity.getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit();
            menuItem.setChecked(true);
            activity.setTitle(menuItem.getTitle());
            mDrawer.closeDrawer(GravityCompat.START);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
