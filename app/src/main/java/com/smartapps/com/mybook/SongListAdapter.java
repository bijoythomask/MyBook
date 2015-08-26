package com.smartapps.com.mybook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by bijoy on 24/8/15.
 */
public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongInfoViewHolder> {

    LayoutInflater inflater;

    List<SongInfo> data = Collections.emptyList();

    public SongListAdapter(Context context, List<SongInfo> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public SongInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.song_info, parent, false);

        SongInfoViewHolder viewHolder = new SongInfoViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SongInfoViewHolder holder, int position) {

        SongInfo info = data.get(position);
        holder.songNumber.setText(Integer.toString(info.songNumber));
        holder.songTitle.setText(info.songTitle);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SongInfoViewHolder extends RecyclerView.ViewHolder {

        TextView songNumber;
        TextView songTitle;

        public SongInfoViewHolder(View itemView) {
            super(itemView);
            songNumber = (TextView) itemView.findViewById(R.id.songNumber);
            songTitle = (TextView) itemView.findViewById(R.id.songTitle);
        }
    }
}
