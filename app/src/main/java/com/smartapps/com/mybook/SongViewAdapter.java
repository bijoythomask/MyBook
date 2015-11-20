package com.smartapps.com.mybook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartapps.com.mybook.model.Song;

/**
 * Created by bijoy on 2/9/15.
 */
public class SongViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflator;
    private Song song;

    public SongViewAdapter(Context context, Song song){
        this.context = context;
        this.song =song;
        layoutInflator =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return song.corusList.size();
    }

    @Override
    public Object getItem(int position) {
        return song.corusList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null) {
            convertView = layoutInflator.inflate(R.layout.lyrics, null);

            TextView corusNo =  (TextView)convertView.findViewById(R.id.corusNo);
            corusNo.setText(Integer.toString(song.corusList.get(position).corusNo));

            TextView corusText =  (TextView)convertView.findViewById(R.id.corusText);
            corusText.setText(song.corusList.get(position).corusText);

            TextView corusInstruction =  (TextView)convertView.findViewById(R.id.corusInstruction);
            corusInstruction.setText(song.corusList.get(position).corusText);

        }
        return convertView;
    }
}
