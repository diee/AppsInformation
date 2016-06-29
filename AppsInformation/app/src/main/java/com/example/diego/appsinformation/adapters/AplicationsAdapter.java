package com.example.diego.appsinformation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diego.appsinformation.R;
import com.example.diego.appsinformation.model.Application;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Diego on 24/06/2016.
 */
public class AplicationsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Application> aplicaciones;

    public AplicationsAdapter(Context context, ArrayList<Application> aplicaciones) {
        this.context = context;
        this.aplicaciones = aplicaciones;
    }

    @Override
    public int getCount() {
        return aplicaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return aplicaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return aplicaciones.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.item_grid, null);

        } else {
            gridView = convertView;
        }

        TextView textView = (TextView) gridView.findViewById(R.id.tvNameApp);
        textView.setText(aplicaciones.get(position).getName());

        ImageView imageView = (ImageView) gridView.findViewById(R.id.imgApp);
        Picasso.with(context).load(aplicaciones.get(position).getImg53()).into(imageView);

        return gridView;
    }
}
