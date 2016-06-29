package com.example.diego.appsinformation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.diego.appsinformation.R;

import java.util.ArrayList;

/**
 * Created by Diego on 26/06/2016.
 */
public class CategoriesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> categories;

    public CategoriesAdapter(Context context, ArrayList<String> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.item_category, null);

        } else {
            gridView = convertView;
        }

        TextView textView = (TextView) gridView.findViewById(R.id.tvCategory);
        textView.setText(categories.get(position));
        return gridView;
    }
}
