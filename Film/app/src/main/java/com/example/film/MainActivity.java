package com.example.film;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.film.controller.FilmController;
import com.example.film.model.Film;
import com.example.film.model.FilmAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FilmController controller;
    FilmAdapter adapter;
    ArrayList<Film> films;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences(getString(R.string.prefs_name), Context.MODE_PRIVATE);

        listView = findViewById(R.id.lv_films);
        films = new ArrayList<Film>();
        adapter = new FilmAdapter(this, R.layout.row, films);
        listView.setAdapter(adapter);
        controller = FilmController.get(this);

        islogged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("id", films.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showFilms();
    }

    private void showFilms() {
        films.clear();
        films.addAll(controller.getFilms());
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                openForm();
                return (true);

            case R.id.action_inspiration:
                openInspiration();
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    public void openForm () {
        Intent intent = new Intent(MainActivity.this, FormActivity.class);
        startActivity(intent);
    }

    public void openInspiration(){
        Intent intent = new Intent(MainActivity.this, InspirationActivity.class);
        startActivity(intent);
    }

    public void islogged() {
        String email= prefs.getString("email", "");
        if("".equals(email)){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
