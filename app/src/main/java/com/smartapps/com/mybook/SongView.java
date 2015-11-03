package com.smartapps.com.mybook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.smartapps.com.mybook.service.SongsProvider;
import com.smartapps.com.mybook.model.Song;

public class SongView extends AppCompatActivity {

    SongsProvider songProvider = new SongsProvider();

    Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_view);
        int songNo = getIntent().getIntExtra("SONG_NO", 0);
        song = songProvider.getSong(songNo);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new SongViewAdapter(this, song));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_song_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
