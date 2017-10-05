package com.android.chunter.officescoretracker.models;

import android.graphics.drawable.Drawable;

public class Game {

    private String mName;

    public Game(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
