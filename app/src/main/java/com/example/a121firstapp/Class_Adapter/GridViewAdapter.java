package com.example.a121firstapp.Class_Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a121firstapp.Class_item.Article;
import com.example.a121firstapp.R;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter implements Filterable {

    private Context context;
    private int layout;
    ArrayList<Article> arrayList;
    ArrayList<Article> mStringFilterList;
    ValueFilter valueFilter;

    public GridViewAdapter(Context context, int layout, ArrayList<Article> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
        mStringFilterList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, null);
        }

        Article article = arrayList.get(position);
        ImageView img = (ImageView) view.findViewById(R.id.grid_imageView);
        TextView name = (TextView) view.findViewById(R.id.grid_title);
        TextView posts = (TextView) view.findViewById(R.id.grid_posts);
        TextView price = (TextView) view.findViewById(R.id.grid_price);

        name.setText(article.getName());
        posts.setText(article.getPosts());
        img.setImageResource(article.getImage());
        price.setText((article.getPrice()));
        return view;
    }

    @Override
    public android.widget.Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new GridViewAdapter.ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends android.widget.Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<Article> filterList = new ArrayList<Article>();
                for (int i = 0; i < mStringFilterList.size(); i++) {
                    if ((mStringFilterList.get(i).getName().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {

                        Article country = new Article(mStringFilterList.get(i)
                                .getId(), mStringFilterList.get(i)
                                .getName(), mStringFilterList.get(i)
                                .getPosts(), mStringFilterList.get(i)
                                .getImage(), mStringFilterList.get(i)
                                .getPrice(), mStringFilterList.get(i)
                                .getColor(), mStringFilterList.get(i)
                                .getBrand(), mStringFilterList.get(i)
                                .getCategory(), mStringFilterList.get(i)
                                .getYear());

                        filterList.add(country);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            arrayList = (ArrayList<Article>) results.values;
            notifyDataSetChanged();
        }
    }
}
