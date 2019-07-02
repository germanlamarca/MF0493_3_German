package com.example.film;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.film.controller.FilmController;
import com.example.film.model.Film;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    ImageView iv_image;
    TextView tv_filmTitle, tv_filmDescription, tv_filmYear, tv_filmScore;
    FilmController controller;
    Film film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String id = getIntent().getStringExtra("id");
        controller = FilmController.get(this);

        film = controller.getFilm(id);

        tv_filmTitle = findViewById(R.id.tv_filmTitle);
        tv_filmDescription = findViewById(R.id.tv_filmDescription);
        tv_filmYear = findViewById(R.id.tv_filmYear);
        tv_filmScore = findViewById(R.id.tv_filmScore);
        iv_image = findViewById(R.id.iv_image);

        showPerson();

    }

    private void showPerson() {
        tv_filmTitle.setText(film.getTitle());
        tv_filmDescription.setText(film.getDescription());
        tv_filmYear.setText(String.valueOf(film.getYear()));
        tv_filmScore.setText(String.valueOf(film.getScore()));
        Picasso.get().load(film.getUri()).into(iv_image);
    }

    public void deleteFilmPressed(View view) {
        controller.deleteFilm(film);
        finish();
    }
}
