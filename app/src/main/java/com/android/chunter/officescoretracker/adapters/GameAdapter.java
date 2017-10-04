package com.android.chunter.officescoretracker.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.chunter.officescoretracker.R;
import com.android.chunter.officescoretracker.models.Game;

import java.util.List;


public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private List<Game> mGameList;
    private GameOnClickHandler mGameOnClickHandler;
    private static final String TAG = GameAdapter.class.getSimpleName();

    public GameAdapter(List<Game> gameList, GameOnClickHandler gameOnClickHandler) {
        mGameList = gameList;
        mGameOnClickHandler = gameOnClickHandler;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_item, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        holder.gameImage.setImageDrawable(mGameList.get(position).getImage());

        holder.gameName.setText(mGameList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mGameList.size();
    }

    public interface GameOnClickHandler {

        void onClick(String gameName);
    }

    class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final CardView gameCard;
        final ImageView gameImage;
        final TextView gameName;

        GameViewHolder(View itemView) {
            super(itemView);

            gameCard = itemView.findViewById(R.id.game_card);
            gameImage = itemView.findViewById(R.id.game_item_image);
            gameName = itemView.findViewById(R.id.game_item_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mGameOnClickHandler.onClick(gameName.getText().toString());
        }
    }
}
