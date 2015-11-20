package com.smartapps.com.mybook.adapter;

import android.content.ContentValues;
import android.database.Cursor;
import com.smartapps.com.mybook.model.SongInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bijoy on 12/9/15.
 */
public class SongInfoAdapter {

    public static String TABLE_NAME = "SONG_INFO";

    public static String QUERY_CREATE = "CREATE TABLE SONG_INFO ( _ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, TITLE TEXT NOT NULL, LANGUAGE VARCHAR(20) NOT NULL); ";

    private static String COL_ID = "_id";
    private static String COL_TITLE = "TITLE";
    private static String COL_LANGUAGE = "LANGUAGE";

    SongInfo songInfo;

    public SongInfoAdapter(SongInfo info) {
        songInfo = info;
    }

    public ContentValues getContentValues(){

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TITLE,songInfo.songTitle);
        contentValues.put(COL_LANGUAGE,songInfo.songLanguage);
        return contentValues;

    }

    public static String[] getColumns(){
        return new String[]{COL_ID, COL_TITLE, COL_LANGUAGE };
    }

    public static List<SongInfo> parseResult(Cursor cursor) {
        List<SongInfo> infoArrayList = new ArrayList<SongInfo>();
        while (cursor.moveToNext()){
            SongInfo songInfo = new SongInfo();
            songInfo.songNumber = cursor.getInt(0);
            songInfo.songTitle = cursor.getString(1);
            songInfo.songLanguage = cursor.getString(2);
            infoArrayList.add(songInfo);
        }
        return infoArrayList;
    }
}
