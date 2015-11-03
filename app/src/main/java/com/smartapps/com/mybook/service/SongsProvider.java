package com.smartapps.com.mybook.service;

import com.smartapps.com.mybook.model.Corus;
import com.smartapps.com.mybook.model.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bijoy on 2/9/15.
 */
public class SongsProvider {

    List<Song> songList = new ArrayList<Song>();

    public SongsProvider() {
        init();
    }

    private void init() {

        for (int i = 0; i < 20; i++) {
            songList.add(createSong(i));
        }

    }

    private Song createSong(int i) {

        Song song = new Song();

        for (i = 0; i < 5; i++) {
            song.corusList.add(crateCorus(i));
        }

        return song;
    }

    private Corus crateCorus(int i) {

        Corus corus = new Corus();
        corus.corusNo = i;
        corus.corusText = "Sample Corus " + i + "1\n";
        corus.corusText = "Sample Corus " + i + "2\n";
        corus.corusText = "Sample Corus " + i + "3\n";
        corus.corusText = "Sample Corus " + i + "4\n";
        return corus;
    }

    public Song getSong(int intex) {

        return songList.get(intex);

    }

    public List<Song> getSongs() {

        return songList;
    }

}
