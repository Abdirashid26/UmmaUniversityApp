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

public class NewsAdapter extends ArrayAdapter<Feed> {


    private int resourceLayout;
    private Context mContext;

    public NewsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Feed> objects) {
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

        Feed p = getItem(position);

        TextView title,fullText,date;

        title = v.findViewById(R.id.title);
        fullText = v.findViewById(R.id.fullText);
        date = v.findViewById(R.id.date);


        title.setText(p.getTitle());
        fullText.setText(p.getFulltext());
        date.setText(p.getDate());




        return v;
    }

}
