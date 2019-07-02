package com.example.film.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.film.model.Film;

import java.util.List;

@Dao
public interface FilmDao {

    @Query("SELECT * FROM film")
    List<Film> getFilms();

    @Query("SELECT * FROM film WHERE id LIKE :uuid")
    Film getFilm(String uuid);

    @Insert
    void addFilm(Film f);

    @Delete
    void deleteFilm(Film f);

    @Update
    void updateFilm(Film f);
}
