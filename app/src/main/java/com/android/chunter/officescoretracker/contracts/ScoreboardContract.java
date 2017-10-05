package com.android.chunter.officescoretracker.contracts;

import com.android.chunter.officescoretracker.models.Standing;

import java.util.List;

public interface ScoreboardContract {

    interface Presenter {

        void retrieveStandings();
    }

    interface View {

        void displayStandings(List<Standing> standingList);
    }
}
