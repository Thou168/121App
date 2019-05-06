package com.example.a121firstapp.Class_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a121firstapp.Class_item.Article;
import com.example.a121firstapp.R;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<Article> articles;
    private LayoutInflater layoutInflater;
    public CustomListAdapter(Context aContext, ArrayList<Article> articles) {
        this.articles = articles;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return articles.size();
    }
    @Override
    public Object getItem(int position) {
        return articles.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View v, ViewGroup vg) {
        ViewHolder holder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.uName = (TextView) v.findViewById(R.id.list_title);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.uName.setText(articles.get(position).getName());
        return v;
    }
    static class ViewHolder {
        TextView uName;
    }
}
