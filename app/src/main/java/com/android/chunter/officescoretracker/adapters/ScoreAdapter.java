package com.android.chunter.officescoretracker.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.chunter.officescoretracker.R;
import com.android.chunter.officescoretracker.models.Standing;

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {

    private Context mContext;
    private List<Standing> mStandings;

    public ScoreAdapter(Context context, List<Standing> standings) {
        mContext = context;
        mStandings = standings;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_scoreboard, parent, false);

        return new ScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {
        Resources resources = mContext.getResources();
        Standing standing = mStandings.get(position);

        holder.positionView.setText(position + 1);
        holder.nameView.setText(standing.getName());
        holder.winsView.setText(resources.getString(R.string.scoreboard_wins, standing.getWins()));
        holder.drawsView.setText(resources.getString(R.string.scoreboard_draws, standing.getDraws()));
        holder.lossesView.setText(resources.getString(R.string.scoreboard_losses, standing.getLosses()));
        holder.pointsView.setText(standing.getPoints());
    }

    @Override
    public int getItemCount() {
        return mStandings.size();
    }

    class ScoreViewHolder extends RecyclerView.ViewHolder {

        final TextView drawsView;
        final TextView lossesView;
        final TextView nameView;
        final TextView pointsView;
        final TextView positionView;
        final TextView winsView;

        ScoreViewHolder(View itemView) {
            super(itemView);

            positionView = itemView.findViewById(R.id.scoreboard_position);
            nameView = itemView.findViewById(R.id.scoreboard_name);
            winsView = itemView.findViewById(R.id.scoreboard_wins);
            drawsView = itemView.findViewById(R.id.scoreboard_draws);
            lossesView = itemView.findViewById(R.id.scoreboard_losses);
            pointsView = itemView.findViewById(R.id.scoreboard_points);
        }
    }
}
