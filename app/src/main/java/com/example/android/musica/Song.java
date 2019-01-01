package com.example.android.musica;

import android.content.res.Resources;

public class Song {
    private int songId;
    private float duration;
    private String songName;
    private String artist;
    private int album;


    /**
     * The class refers to songs.
     *
     * @param songName is the name of the song like "Let it go"
     * @param artist   is the name of the singer like "Disney"
     * @param duration is the duration of the song, like X minutes
     */
    public Song(int songId, float duration, String songName, String artist, int album) {
        this.songId = songId;
        this.duration = duration;
        this.songName = songName;
        this.artist = artist;
        this.album = album;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }
}