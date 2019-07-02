package com.example.film;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.film.model.GhibliAdapter;
import com.example.film.model.GhibliFilm;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InspirationActivity extends AppCompatActivity {

    GhibliAdapter adapter;
    ArrayList<GhibliFilm> ghibliFilms;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration);

        ghibliFilms = new ArrayList<GhibliFilm>();
        listView = findViewById(R.id.lv_inspiration);
        adapter = new GhibliAdapter(this, R.layout.ghibli_row, ghibliFilms);

        listView.setAdapter(adapter);

        getFilmsFromRetrofit();
    }

    private void getFilmsFromRetrofit() {

        MyService service = RetrofitClientInstance.getRetrofitInstance().create(MyService.class);
        Call<List<GhibliFilm>> call = ((MyService) service).ghibliFilms();
        call.enqueue(new Callback<List<GhibliFilm>>() {

            @Override
            public void onResponse(Call<List<GhibliFilm>> call, Response<List<GhibliFilm>> response) {
                ghibliFilms.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GhibliFilm>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_LONG).show();
            }
        });
    }
}
