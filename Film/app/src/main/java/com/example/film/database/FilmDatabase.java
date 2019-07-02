package com.example.film.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.film.model.Film;

@Database(entities = {Film.class}, version=1)
public abstract class FilmDatabase extends RoomDatabase {
    public abstract FilmDao getFilmDao();
}
