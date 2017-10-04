package com.android.chunter.officescoretracker.activities;

import static com.android.chunter.officescoretracker.activities.MainActivity.GAME_NAME_KEY;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.chunter.officescoretracker.R;

public class ScoreboardActivity extends AppCompatActivity {

    private TextView mGameNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        String gameName = getIntent().getStringExtra(GAME_NAME_KEY);

        mGameNameTextView = findViewById(R.id.game_name);
        mGameNameTextView.setText(gameName);
    }
}
