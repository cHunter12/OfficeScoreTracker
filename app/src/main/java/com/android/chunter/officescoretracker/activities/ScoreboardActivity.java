package com.android.chunter.officescoretracker.activities;

import static com.android.chunter.officescoretracker.activities.MainActivity.GAME_NAME_KEY;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.android.chunter.officescoretracker.R;
import com.android.chunter.officescoretracker.adapters.StandingAdapter;
import com.android.chunter.officescoretracker.contracts.ScoreboardContract;
import com.android.chunter.officescoretracker.models.Standing;
import com.android.chunter.officescoretracker.presenters.ScoreboardPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreboardActivity extends AppCompatActivity implements ScoreboardContract.View {

    private ScoreboardContract.Presenter mPresenter;
    private StandingAdapter mStandingAdapter;
    List<Standing> mStandingList = new ArrayList<>();

    @Override
    public void displayStandings(List<Standing> standingList) {
        mStandingList.addAll(standingList);
        mStandingAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        String gameName = getIntent().getStringExtra(GAME_NAME_KEY);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(gameName);

        setupRecyclerView();

        mPresenter = new ScoreboardPresenter(this);
        mPresenter.retrieveStandings();
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mStandingAdapter = new StandingAdapter(this, mStandingList);

        RecyclerView scoreboardRecyclerView = findViewById(R.id.scoreboard_list);
        scoreboardRecyclerView.setLayoutManager(linearLayoutManager);
        scoreboardRecyclerView.setAdapter(mStandingAdapter);
    }
}
