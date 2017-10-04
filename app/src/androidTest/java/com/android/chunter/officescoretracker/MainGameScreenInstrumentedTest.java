package com.android.chunter.officescoretracker;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.android.chunter.officescoretracker.activities.MainActivity;
import com.android.chunter.officescoretracker.activities.ScoreboardActivity;

@RunWith(AndroidJUnit4.class)
public class MainGameScreenInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    /*
        Will test that selecting a game from the game list will open the Scoreboard activity
     */
    @Test
    public void clickingGameWillOpenScoreboardScreen() {
        Intents.init();

        onView(withId(R.id.games_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        intended(hasComponent(ScoreboardActivity.class.getName()));

        Intents.release();
    }
}
