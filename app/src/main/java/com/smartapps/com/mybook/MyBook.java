package com.smartapps.com.mybook;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.smartapps.com.mybook.adapter.DBAdapter;
import com.smartapps.com.mybook.service.SongsProvider;
import com.smartapps.com.mybook.model.SongInfo;

import java.util.ArrayList;
import java.util.List;


public class MyBook extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView songList;

    private SongListAdapter adapter;

    private Activity activity;

    private DBAdapter dbAdapter;

    SongsProvider songProvider = new SongsProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = this;
        setContentView(R.layout.activity_mybook);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        NavigationDrawerFragment navigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        navigationDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        dbAdapter = new DBAdapter(this);

        songList = (RecyclerView) findViewById(R.id.songsList);
        adapter = new SongListAdapter(this, getData());
        songList.setAdapter(adapter);
        songList.setLayoutManager(new LinearLayoutManager(this));
        songList.addOnItemTouchListener(new SongListTouchListener(this, songList, new ClickListener() {
            @Override
            public void onLongPress(View child, int childPosition) {
                //Toast.makeText(activity, "On long press  " + childPosition, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, SongView.class);
                intent.putExtra("SONG_NO", childPosition);
                startActivity(intent);
            }

            @Override
            public void onClick(View child, int childPosition) {
                //Toast.makeText(activity, "On click " + childPosition, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, SongView.class);
                intent.putExtra("SONG_NO", childPosition);
                startActivity(intent);
            }
        }));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mybook, menu);
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

    private List<SongInfo> getData() {

        List<SongInfo> songsList = new ArrayList<>();

//        String[] songArray = {"Who Am I Lyrics", "You Are My King (Amazing Love) Lyrics", "By His Wounds Lyrics", "God of Wonders Lyrics", "I Can Only Imagine Lyrics",
//                "Breathe Lyrics"};
//        int count = 0;
//        for (String song : songArray) {
//            SongInfo songInfo = new SongInfo(count++, song);
//            songsList.add(songInfo);
//            //dbAdapter.insertSongIngo(songInfo);
//        }

        return dbAdapter.getSongInfoList();
    }
}
