package com.example.film;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.film.controller.FilmController;
import com.example.film.model.Film;

public class FormActivity extends AppCompatActivity {

    FilmController controller;
    EditText et_title, et_description, et_year, et_score, et_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        et_year = findViewById(R.id.et_year);
        et_score = findViewById(R.id.et_score);
        et_uri = findViewById(R.id.et_uri);

        controller = FilmController.get(this);
    }

    public void addFilmPressed(View view) {
        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        String year = et_year.getText().toString();
        String score = et_score.getText().toString();
        String uri = et_uri.getText().toString();

        if(checkFields(title,description,year,score,uri)) {

            Film f = new Film(title,description,Integer.parseInt(year),Integer.parseInt(score),uri);
            FilmController.get(this).createFilm(f);

            finish();
        }
    }

    private boolean checkFields(String title, String description, String year, String score, String uri) {
        boolean result = true;

        if ("".equals(title)) {
            et_title.setError(getString(R.string.empty));
            result= false;
        }
        if ("".equals(description)) {
            et_description.setError(getString(R.string.empty));
            result= false;
        }
        if ("".equals(year)){
            et_year.setError(getString(R.string.empty));
            result= false;
        }
        if ("".equals(score)){
            et_score.setError(getString(R.string.empty));
            result= false;
        }else{
            Integer.parseInt(score);
            if (((Integer.parseInt(score)) < 0) || ((Integer.parseInt(score)) > 5)){
                et_score.setError(getString(R.string.wrongScore));
                result= false;
            }
        }
        if ("".equals(uri)){
            et_uri.setError(getString(R.string.empty));
            result= false;
        }
        return result;
    }
}
