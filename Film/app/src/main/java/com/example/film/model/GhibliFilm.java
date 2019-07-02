package com.example.film.model;

import android.arch.persistence.room.Entity;

public class GhibliFilm {

    String title;

    public GhibliFilm(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
