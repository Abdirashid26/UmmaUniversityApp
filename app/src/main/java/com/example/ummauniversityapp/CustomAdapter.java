package com.example.ummauniversityapp;


import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<News> {

    private int resourceLayout;
    private Context mContext;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<News> objects) {
        super(context, resource, objects);

        resourceLayout = resource;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        News p = getItem(position);

        TextView title,admin,date;
        ImageView image;

        title = v.findViewById(R.id.titles);
        admin = v.findViewById(R.id.admin);
        date = v.findViewById(R.id.date);
        image = v.findViewById(R.id.feedImage);


        title.setText(p.getTitle());
        admin.setText(p.getAdmin());
        date.setText(p.getDate());

        Uri uri = Uri.parse(p.getImage());


        Picasso.get().load(p.getImage()).into(image);


        return v;
    }


}

