package com.momo;

public class Songs {
    private String songTitle; // Song title
    private double duration; // Song duration

    public Songs(String songTitle, double duration){
        this.songTitle = songTitle;
        this.duration = duration;
    }
    // Return the song title
    public String getSongTitle() {
        return songTitle;
    }

    // return the duration of the song
    public double getDuration() {
        return duration;
    }



    @Override
    public String toString() {
        return "Song: "+this.getSongTitle() + " duration: "+this.duration;
    }
}
