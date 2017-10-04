package com.android.chunter.officescoretracker.models;

import android.support.annotation.NonNull;

public class Standing implements Comparable<Standing> {

    private int mDraws;
    private int mLosses;
    private String mName;
    private int mPoints;
    private int mWins;

    public Standing(String name, int wins, int draws, int losses, int points) {
        mName = name;
        mWins = wins;
        mDraws = draws;
        mLosses = losses;
        mPoints = points;
    }

    @Override
    public int compareTo(@NonNull Standing o) {
        return (getPoints() - o.getPoints());
    }

    public int getDraws() {
        return mDraws;
    }

    public void setDraws(int draws) {
        mDraws = draws;
    }

    public int getLosses() {
        return mLosses;
    }

    public void setLosses(int losses) {
        mLosses = losses;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getPoints() {
        return mPoints;
    }

    public void setPoints(int points) {
        mPoints = points;
    }

    public int getWins() {
        return mWins;
    }

    public void setWins(int wins) {
        mWins = wins;
    }
}
