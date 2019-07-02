package com.example.film;

import com.example.film.model.GhibliFilm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyService {

    @GET("films/")
    Call<List<GhibliFilm>> ghibliFilms();
}


