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

public class FilmAdapter extends ArrayAdapter<Film> {

    int layoutResourceId;
    Context context;
    ArrayList<Film> data;

    public FilmAdapter(Context context, int layoutResourceId, ArrayList<Film> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        Film f = data.get(position);

        TextView tv_title = row.findViewById(R.id.tv_title);
        TextView tv_score = row.findViewById(R.id.tv_score);

        String title = data.get(position).getTitle();
        int score = f.getScore();

        tv_title.setText(title);
        tv_score.setText(String.valueOf(f.getScore()));

        if(score == 0 || score == 1) {
            tv_title.setTextColor(context.getResources().getColor(R.color.red));
            tv_score.setTextColor(context.getResources().getColor(R.color.red));
        }else if (score == 2 || score == 3) {
            tv_title.setTextColor(context.getResources().getColor(R.color.black));
            tv_score.setTextColor(context.getResources().getColor(R.color.black));
        }else if (score == 4 || score == 5) {
            tv_title.setTextColor(context.getResources().getColor(R.color.green));
            tv_score.setTextColor(context.getResources().getColor(R.color.green));
        }
        return row;
    }
}
