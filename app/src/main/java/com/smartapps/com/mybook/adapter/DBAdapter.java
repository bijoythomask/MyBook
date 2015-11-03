package com.smartapps.com.mybook.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.smartapps.com.mybook.model.SongInfo;

import java.util.List;

/**
 * Created by bijoy on 12/9/15.
 */
public class DBAdapter extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;

    private static String DB_NAME = "SONGS_DB";


    public DBAdapter(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SongInfoAdapter.QUERY_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertSongIngo(SongInfo songInfo) {
        SongInfoAdapter songInfoAdapter = new SongInfoAdapter(songInfo);
        SQLiteDatabase db = getWritableDatabase();
        long insert = db.insert(SongInfoAdapter.TABLE_NAME, null, songInfoAdapter.getContentValues());
        return insert;
    }

    public List<SongInfo> getSongInfoList() {
        Cursor cursor = getReadableDatabase().query(SongInfoAdapter.TABLE_NAME, SongInfoAdapter.getColumns(), null, null, null, null, null);
        return SongInfoAdapter.parseResult(cursor);
    }

}
