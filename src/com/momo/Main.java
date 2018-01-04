package com.momo;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Main {
    // An ArrayList of albums
    private static ArrayList<Album> songAlbums = new ArrayList<>();
    public static void main(String[] args) {

        // Instantiation of an album
        Album album = new Album("Chris Brown","Heartbreak on the Full Moon");
        // Adding of various song album
        album.addSong("Lost & Found", 4.01);
        album.addSong("Privacy", 3.40);
        album.addSong("Juicy Booty", 4.33);
        album.addSong("Questions", 2.09);
        album.addSong("Heartbreak on a Full Moon", 4.06);
        album.addSong("Roses", 3.24);
        album.addSong("Confidence", 2.57);
        album.addSong("Rock Your Body", 3.38);
        album.addSong("Tempo", 4.01);
        album.addSong("Handle It", 4.41);
        songAlbums.add(album);
        album = new Album("Beyonce", "Lemonade");
        album.addSong("Pray You Catch Me", 3.16);
        album.addSong("Hold Up", 3.41);
        album.addSong("Don't Hurt Yourself", 3.53);
        album.addSong("Sorry", 3.52);
        album.addSong("6 Inch", 4.20);
        album.addSong("Love Drought", 3.57);
        album.addSong("SandCastles", 3.02);
        album.addSong("Forward", 1.09);
        album.addSong("Freedom", 4.49);
        album.addSong("All Night", 5.22);
        // Add album to songs album
        songAlbums.add(album);

        // A LinkedList of songs that serves as a play list
        LinkedList<Songs> playlist = new LinkedList<>();
        // Adds songs to the playlist using their track number and song title
        songAlbums.get(0).addToPlayList(1, playlist);
        songAlbums.get(0).addToPlayList(2, playlist);
        songAlbums.get(0).addToPlayList(3, playlist);
        songAlbums.get(0).addToPlayList(4, playlist);
        songAlbums.get(0).addToPlayList(5, playlist);
        songAlbums.get(0).addToPlayList(6, playlist);
        songAlbums.get(0).addToPlayList(7, playlist);
        songAlbums.get(0).addToPlayList(8, playlist);
        songAlbums.get(0).addToPlayList(9, playlist);
        songAlbums.get(0).addToPlayList(17, playlist);// This track doesn't exist in play list. For debugging purposes
        songAlbums.get(1).addToPlayList("Pray You Catch Me", playlist);
        songAlbums.get(1).addToPlayList("Hold Up", playlist);
        songAlbums.get(1).addToPlayList("Don't Hurt Yourself", playlist);
        songAlbums.get(1).addToPlayList("Sorry", playlist);
        songAlbums.get(1).addToPlayList("6 Inch", playlist);
        songAlbums.get(1).addToPlayList("Love Drought", playlist);
        songAlbums.get(1).addToPlayList("SandCastles", playlist);
        songAlbums.get(1).addToPlayList("Forward", playlist);
        songAlbums.get(1).addToPlayList("Freedom", playlist);
        songAlbums.get(1).addToPlayList("All Night", playlist);
        songAlbums.get(1).addToPlayList("Doesn't Exist", playlist); // This song doesn't exist in playlist. For debugging purposes
        // Add second album to song album
        songAlbums.add(album);

        playSong(playlist);

    }

    // A static method that call to play various songs added to the playlist
    private static void playSong(LinkedList<Songs> playSongs){
        ListIterator<Songs> songsListIterator = playSongs.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false; //
        boolean forward = true; // Track direction of list iterator
        displayMenu();
        if(playSongs.isEmpty()){
            System.out.println("There is no songs in the playlist");
            return;
        }else {
            System.out.println("Now playing "+songsListIterator.next().toString());
        }
        while (!quit){

            System.out.println("");
            // Get a valid number from the user
            int choice = validNumber();

            switch (choice){
                case 0:
                    System.out.println("Exiting playlist...Thanks for using our playlist program...");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if (songsListIterator.hasNext()) {
                            songsListIterator.next();
                        }
                        forward = true;
                    }
                        if (songsListIterator.hasNext()) {
                            System.out.print("Now playing " + songsListIterator.next().toString());
                        } else {
                            System.out.println("You are at the end of the playlist");
                        }
                    break;
                    case 2:
                    if(forward){
                        if(songsListIterator.hasPrevious()){
                            songsListIterator.previous();
                        }
                        forward = false;
                    }
                    if(songsListIterator.hasPrevious()){
                        System.out.print("Now playing "+ songsListIterator.previous().toString());
                    }else {
                        System.out.println("You are at the beginning of the play list");
                    }
                    break;

                case 3:
                    displaySongs(playSongs);
                    break;
                case 4:
                    if(forward){
                        if(songsListIterator.hasPrevious()){
                            System.out.printf("Now replaying %s", songsListIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("You are at the beginning of the playlist");
                        }
                    }else {
                        if(songsListIterator.hasNext()){
                            System.out.printf("Now replaying %s", songsListIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("You are at the end of the playlist");
                        }
                    }

                    break;
                case 5:
                    displayMenu();
                    break;
                case 6:
                    if(!playSongs.isEmpty()){
                        songsListIterator.remove();
                        if(songsListIterator.hasNext()){
                            System.out.printf("Now playing %s%n", songsListIterator.next().toString());
                        }else if(songsListIterator.hasPrevious()){
                            System.out.printf("Now playing %s%n", songsListIterator.previous().toString());
                        }
                    }
                    break;
            }
        }
    }
    // Display the various songs in the playlist
    private static void displaySongs(LinkedList<Songs> songs){
        Iterator<Songs> songIter = songs.listIterator();
        while (songIter.hasNext()){
            System.out.println(songIter.next().toString());
        }
    }

    // Display menu option
    private static void displayMenu(){
        System.out.printf("0-------> Exit the program%n1 ------->play next song%n2------->Play previous song%n3-------> Display Songs songs" +
                "%n4-------> Replay a song%n5------->Print menu option%n6------->Delete current playing song%n");
    }

    // Validate user input by ensuring that they enter a number
    public static int validNumber(){
        Scanner input = new Scanner(System.in);
        int numberEnter = 0;
        boolean isNumber = true;
        do{
            try{
                System.out.print("Enter choice for the music you want to play:  ");
                 numberEnter = input.nextInt();
                 isNumber = false;

            }catch (InputMismatchException exe){
                System.out.println("Please enter a valid number");
                input.nextLine();

            }
        }while (isNumber);

        return numberEnter;
    }
}
