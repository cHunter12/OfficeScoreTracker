package com.android.chunter.officescoretracker.activities;

import static com.android.chunter.officescoretracker.activities.MainActivity.GAME_NAME_KEY;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.chunter.officescoretracker.R;
import com.android.chunter.officescoretracker.adapters.ScoreAdapter;
import com.android.chunter.officescoretracker.models.Standing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreboardActivity extends AppCompatActivity {

    List<Standing> mStandingList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        String gameName = getIntent().getStringExtra(GAME_NAME_KEY);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(gameName);

        setupPlaceholderData();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        ScoreAdapter gameAdapter = new ScoreAdapter(this, mStandingList);

        RecyclerView scoreboardRecyclerView = findViewById(R.id.scoreboard_list);
        scoreboardRecyclerView.setLayoutManager(linearLayoutManager);
        scoreboardRecyclerView.setAdapter(gameAdapter);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
