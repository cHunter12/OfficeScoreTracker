package com.android.chunter.officescoretracker.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.chunter.officescoretracker.R;
import com.android.chunter.officescoretracker.adapters.GameAdapter;
import com.android.chunter.officescoretracker.contracts.MainContract;
import com.android.chunter.officescoretracker.models.Game;
import com.android.chunter.officescoretracker.presenters.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        MainContract.View,
        GameAdapter.GameOnClickHandler {

    private GameAdapter mGameAdapter;
    private List<Game> mGameList = new ArrayList<>();
    private MainContract.Presenter mPresenter;
    public static final String GAME_NAME_KEY = "game_name";

    @Override
    public void displayGames(List<Game> gameList) {
        mGameList.addAll(gameList);
        mGameAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(String gameName) {
        Intent intent = new Intent(this, ScoreboardActivity.class);
        intent.putExtra(GAME_NAME_KEY, gameName);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();

        mPresenter = new MainPresenter(this);
        mPresenter.retrieveGames();
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mGameAdapter = new GameAdapter(mGameList, this);

        RecyclerView gameRecyclerView = findViewById(R.id.games_list);
        gameRecyclerView.setLayoutManager(linearLayoutManager);
        gameRecyclerView.setAdapter(mGameAdapter);
    }
}
