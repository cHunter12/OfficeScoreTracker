package com.android.chunter.officescoretracker.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.chunter.officescoretracker.R;
import com.android.chunter.officescoretracker.RecyclerItemClickListener;
import com.android.chunter.officescoretracker.adapters.GameAdapter;
import com.android.chunter.officescoretracker.models.Game;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GameAdapter.GameOnClickHandler {

    private List<Game> mGameList = new ArrayList<>();
    public static final String GAME_NAME_KEY = "game_name";

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

        setupGames();
        setupRecyclerView();
    }

    private void setupGames() {
        mGameList.add(new Game("Rocket League", getDrawable(android.R.drawable.ic_menu_gallery)));
        mGameList.add(new Game("Fifa", getDrawable(android.R.drawable.ic_menu_gallery)));
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        GameAdapter gameAdapter = new GameAdapter(mGameList, this);

        RecyclerView gameRecyclerView = findViewById(R.id.games_list);
        gameRecyclerView.setLayoutManager(linearLayoutManager);
        gameRecyclerView.setAdapter(gameAdapter);

//        gameRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
//                this, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                String gameName = ((TextView) view.findViewById(R.id.game_item_name)).getText().toString();
//
//                Intent intent = new Intent(MainActivity.this, ScoreboardActivity.class);
//                intent.putExtra(GAME_NAME_KEY, gameName);
//                startActivity(intent);
//            }
//        }));
    }
}
