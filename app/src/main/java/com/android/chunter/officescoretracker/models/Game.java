package com.android.chunter.officescoretracker.models;

import android.graphics.drawable.Drawable;

public class Game {

    private Drawable mImage;
    private String mName;

    public Game(String name, Drawable image) {
        mName = name;
        mImage = image;
    }

    public Drawable getImage() {
        return mImage;
    }

    public void setImage(Drawable image) {
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
