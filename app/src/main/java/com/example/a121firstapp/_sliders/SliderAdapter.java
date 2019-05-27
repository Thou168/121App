package com.example.a121firstapp._sliders;

import android.content.Context;
import android.content.res.Configuration;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a121firstapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SPECBEE on 8/4/2017.
 */

public class SliderAdapter extends PagerAdapter {
    private List<Integer> image;
    private Context context;

    public SliderAdapter(Context context, List<Integer> image) {
        this.context = context;
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_slider, null);

 //       TextView textView = (TextView) view.findViewById(R.id.textView);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
//        ImageView imageView = (ImageView) view.findViewById(R.id.image);


//        imageView.setImageResource(image.get(position));
        linearLayout.setBackgroundResource(image.get(position));

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
