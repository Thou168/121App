package com.example.a121firstapp.Class_item;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.example.a121firstapp.ChangeLanguageActivity;
import java.util.Locale;

public class CommomClass {

    /*
    public void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(this, ChangeLanguageActivity.class);
            refresh.putExtra(currentLang, localeName);
            startActivity(refresh);
        } else {
            //Toast.makeText(ChangeLanguageActivity.this, "Language already selected!", Toast.LENGTH_SHORT).show();
        }
    }
    */
}
