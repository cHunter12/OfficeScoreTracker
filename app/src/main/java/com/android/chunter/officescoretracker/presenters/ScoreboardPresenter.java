package com.android.chunter.officescoretracker.presenters;

import com.android.chunter.officescoretracker.contracts.ScoreboardContract;
import com.android.chunter.officescoretracker.models.Standing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreboardPresenter implements ScoreboardContract.Presenter {

    private List<Standing> mStandingList = new ArrayList<>();
    private ScoreboardContract.View mView;

    public ScoreboardPresenter(ScoreboardContract.View view) {
        mView = view;
    }

    @Override
    public void retrieveStandings() {
        setupPlaceholderData();

        mView.displayStandings(mStandingList);
    }

    // TODO: Get standings from online/Realm
    private void setupPlaceholderData() {
        mStandingList.add(new Standing("Chris", 1, 0, 2, 3));
        mStandingList.add(new Standing("Mark", 2, 1, 3, 7));
        mStandingList.add(new Standing("Nathan", 2, 3, 1, 9));
        mStandingList.add(new Standing("Peter", 1, 1, 1, 4));
        mStandingList.add(new Standing("Jake", 0, 0, 10, 0));
        mStandingList.add(new Standing("Paul", 4, 0, 3, 12));

        Collections.sort(mStandingList, Collections.reverseOrder());
    }
}
