package com.example.film.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.film.R;

import java.util.ArrayList;

public class GhibliAdapter extends ArrayAdapter<GhibliFilm> {

    int layoutResourceId;
    Context context;
    ArrayList<GhibliFilm> data;

    public GhibliAdapter(Context context, int layoutResourceId, ArrayList<GhibliFilm> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ghibli_row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        ghibli_row = inflater.inflate(layoutResourceId, parent, false);

        TextView tv_ghibliTitle = ghibli_row.findViewById(R.id.tv_ghibliTitle);

        GhibliFilm ghibliFilm = data.get(position);
        tv_ghibliTitle.setText(ghibliFilm.getTitle());

        return ghibli_row;
    }
}