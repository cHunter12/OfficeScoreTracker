package com.android.chunter.officescoretracker.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.android.chunter.officescoretracker.R;
import com.android.chunter.officescoretracker.RecyclerItemClickListener;
import com.android.chunter.officescoretracker.adapters.GameAdapter;
import com.android.chunter.officescoretracker.models.Game;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Game> mGameList = new ArrayList<>();
    private static String GAME_KEY = "game";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupGames();
        setupRecyclerView();
    }

    private void setupGames() {
        mGameList.add(new Game("Rocket League", getDrawable(android.R.drawable.ic_delete)));
        mGameList.add(new Game("Fifa", getDrawable(android.R.drawable.ic_delete)));
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        GameAdapter gameAdapter = new GameAdapter(mGameList);

        RecyclerView gameRecyclerView = findViewById(R.id.games_list);
        gameRecyclerView.setLayoutManager(linearLayoutManager);
        gameRecyclerView.setAdapter(gameAdapter);

        gameRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String gameName = ((TextView) view.findViewById(R.id.game_item_name)).getText().toString();

                Intent intent = new Intent(MainActivity.this, ScoreboardActivity.class);
                intent.putExtra(GAME_KEY, gameName);
                startActivity(intent);
            }
        }));
    }

}
