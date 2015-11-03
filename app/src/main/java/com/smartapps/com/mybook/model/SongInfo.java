package com.smartapps.com.mybook.model;

/**
 * Created by bijoy on 24/8/15.
 */
public class SongInfo {

    public static final String ENGLISH = "English";

    public int songNumber;

    public String songTitle;

    public String songLanguage;

    public SongInfo() {

    }

    public SongInfo(int songNumber, String songTitle) {

        this.songTitle = songTitle;
        this.songNumber = songNumber;
        this.songLanguage = ENGLISH;

    }

}
