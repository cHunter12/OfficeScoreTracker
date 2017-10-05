package com.android.chunter.officescoretracker.contracts;

import com.android.chunter.officescoretracker.models.Game;

import java.util.List;

public interface MainContract {

    interface Presenter {

        void retrieveGames();
    }

    interface View {

        void displayGames(List<Game> gameList);
    }
}
