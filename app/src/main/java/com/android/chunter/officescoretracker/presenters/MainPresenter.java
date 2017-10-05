package com.android.chunter.officescoretracker.presenters;

import com.android.chunter.officescoretracker.contracts.MainContract;
import com.android.chunter.officescoretracker.models.Game;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private List<Game> mGameList = new ArrayList<>();
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void retrieveGames() {
        setupPlaceholderGames();

        mView.displayGames(mGameList);
    }

    // TODO: Get games from online/Realm
    private void setupPlaceholderGames() {
        mGameList.add(new Game("Rocket League"));
        mGameList.add(new Game("Fifa"));
        mGameList.add(new Game("Call of Duty"));
    }
}

