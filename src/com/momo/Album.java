package com.momo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private ArrayList<Songs> songs; // A list of songs
    private final String artistName;// Artist name
    private final String albumName; // Album name

    public Album(String artistName, String albumName){
        this.artistName = artistName;
        this.albumName = albumName;
        this.songs = new ArrayList<>();
    }

    // return the name of the album
    public String getAlbumName() {
        return albumName;
    }

    // Adds a song to the songs ArrayList. If the song has already been added, return false
    //otherwise, add the song, return true
    public boolean addSong(String songTitle, double duration){
        int songFound = findSong(songTitle);
        if(songFound >= 0){
            Songs songs = this.songs.get(songFound);
            System.out.printf("Song: %s duration: %s has already been added%n", songs.getSongTitle(), songs.getDuration());
         return false;
        }else {
            this.songs.add(new Songs(songTitle, duration));
        }
        return true;
    }

    // A method that finds each song, and return the index of that song in the list
    // Returns -1 if song doesn't exist in songs ArrayList
    private int findSong(String songName){
        for(int i = 0; i<this.songs.size(); i++){
            Songs songs = this.songs.get(i);
            if(songs.getSongTitle().equalsIgnoreCase(songName)){
                return this.songs.indexOf(songs);
            }
        }
        return -1;

    }
    // Adds a song to a playlist using the song track number. Returns true if the song exist
    // Otherwise, return false
    public boolean addToPlayList(int trackNumber, LinkedList<Songs> playList){
        int index = trackNumber - 1;
        if((index >= 0) && index <= this.songs.size()){
            Songs songs = this.songs.get(index);
            playList.add(songs);
            return true;
        }
        System.out.println("This album does not contain track number "+ trackNumber);
        return false;
    }
    // Adds a song to a playlist by passing the song title returns true if the is added
    //otherwise return false
    public boolean addToPlayList(String songTitle, LinkedList<Songs> playList){
        int index = findSong(songTitle);
        if(index >= 0){
            Songs songs = this.songs.get(index);
            playList.add(songs);
            return true;
        }else {
            System.out.printf("The song %s isn't a valid song%n", songTitle);
            return false;
        }

    }

    // Returns the name of artist
    public String getArtistName() {
        return artistName;
    }
}
