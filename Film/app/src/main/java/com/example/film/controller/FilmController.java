package com.example.film.controller;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.film.database.FilmDao;
import com.example.film.database.FilmDatabase;
import com.example.film.model.Film;

import java.util.List;

public class FilmController {

    private static FilmController controller;
    private FilmDao filmDao;

    private FilmController (Context context) {
        Context appContext = context.getApplicationContext();
        FilmDatabase database = Room.databaseBuilder(appContext, FilmDatabase.class, "film")
                .allowMainThreadQueries().build();
        filmDao = database.getFilmDao();
    }

    public static FilmController get(Context context) {
        if (controller == null) {
            controller = new FilmController(context);
        }
        return controller;
    }

    public List<Film> getFilms() {
        return filmDao.getFilms();
    }

    public Film getFilm (String uuid){
        return filmDao.getFilm(uuid);
    }

    public void createFilm (Film film) {
        filmDao.addFilm(film);
    }

    public void deleteFilm (Film film) {
        filmDao.deleteFilm(film);
    }

    public void updateFilm (Film film) {

        filmDao.updateFilm(film);
    }
}
