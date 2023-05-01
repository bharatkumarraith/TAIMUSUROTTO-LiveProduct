import DAOimplementation.*;
import model.Playlist;
import model.Podcast;
import model.Song;

import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        DBConnection obj = new DBConnection();
        Connection c = obj.GetConnection();
        System.out.println("*************WELCOME TO JUKEBOX***************");
        System.out.println("---------Let's ENJOY the MUSIC--------- ");
        System.out.println("------DO YOU HAVE ACCOUNT IN jukebox--------------");
        System.out.println("1. already i have an account_________________________");
        System.out.println("2. I dont have account want to create_________________");
        System.out.println("__if u have account press 1 OR press 2__");
        int choice = scanner.nextInt();
        UserImpl user = new UserImpl();
        if (choice == 2) {
            boolean flag = user.createAccount();
        } else if (choice == 1) {
            boolean flag = user.login();
            while(flag == true) {
                System.out.println("1. Songs");
                System.out.println("2. Podcast");
                System.out.println("3. Playlist");
                System.out.println("4. Play Song");
                System.out.println("5. Play Podcast");
                System.out.println("6. Exit");
                int choice1=scanner.nextInt();
                System.out.println("_______________________________");
                if (choice1 == 1) {
                    System.out.println("1. Display all Songs");
                    System.out.println("2. Sort all Songs");
                    System.out.println("3. Search Song");
                    System.out.println("4. sort all genre");
                    System.out.println("5. search by genre");
                    System.out.println("6. Add song to playlist");
                    System.out.println("7. Exit");
                    int choice2 = scanner.nextInt();
                    System.out.println("_______________________________");
                    SongsImpl songs = new SongsImpl();
                    switch (choice2) {
                        case 1:
                            System.out.println("----All songs-----");
                            System.out.println("-----------------------------------");
                            List<Song> allSongDets = songs.displayAllSongs();
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.format("  %10s   %10s   %10s    %10s    %10s        %30s     %60s \n","Song_name","Song_id","Song_duration","Artist","Genre","Song_file_path","Playlist_id");
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            for (Song s : allSongDets) {
                                System.out.format("  %-10s      %-10d %-10s     %-10s          %-10s          %-40s     %10s \n",s.getSong_name(),s.getSong_id(),s.getSong_duration(),s.getArtist(),s.getGenre(),s.getSong_file_path(),s.getPlaylist_id());
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");

                            }
                            break;
                        case 2:
                            System.out.println("---------set all songs in order--------------");
                            System.out.println("----------------------------------------------");
                            List<Song> sorted = songs.sortSongs();
                            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.format("%10s %10s %10s %10s %10s %30s %60s \n","Song_name","Song_id","Song_duration","Artist","Genre","Song_file_path","Playlist_id");
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            for (Song s : sorted) {
                                System.out.format("%10s %10d %10s %10s %10s %40s %10d \n",s.getSong_name(),s.getSong_id(),s.getSong_duration(),s.getArtist(),s.getGenre(),s.getSong_file_path(),s.getPlaylist_id());
                                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            }
                            break;
                        case 3:
                            System.out.println("enter your SongId : ");
                            int id = scanner.nextInt();
                            System.out.println("----------------------------");
                            Song song = songs.searchSong(id);
                            System.out.println(song);
                            break;
                        case 4:
                            System.out.println("---------set all genre in order--------");
                            System.out.println("-----------------------------------------");
                            List<Song> sort=songs.sortGenre();
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.format("%10s %10s %10s %10s %10s %30s %60s \n","Song_name","Song_id","Song_duration","Artist","Genre","Song_file_path","Playlist_id");
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            for(Song s: sort)
                                System.out.format("%10s %10d %10s %10s %10s %40s %10d \n",s.getSong_name(),s.getSong_id(),s.getSong_duration(),s.getArtist(),s.getGenre(),s.getSong_file_path(),s.getPlaylist_id());
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        case 5:
                            System.out.println("--------------search by genre---------------");
                            System.out.println("enter the genre");
                            String value=scanner.next();
                            System.out.println("----------------------------------------------");
                            List<Song>search=songs.searchgenre(value);
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.format("%10s %10s %10s %10s %10s %30s %60s \n","Song_name","Song_id","Song_duration","Artist","Genre","Song_file_path","Playlist_id");
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            for(Song s:search) {
                                System.out.format("%10s %10d %10s %10s %10s %40s %10d \n", s.getSong_name(), s.getSong_id(), s.getSong_duration(), s.getArtist(), s.getGenre(), s.getSong_file_path(), s.getPlaylist_id());
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            }
                        case 6:
                        {
                            System.out.println("add song to playlist");
                            System.out.println("-------------------------");
                            songs.AddSongToPlaylist();
                        }
                            case 7:
                            System.exit(0);

                    }
                }
                if (choice1 == 2) {
                    System.out.println("1. Display all Podcasts");
                    System.out.println("2. Sort all Podcasts");
                    System.out.println("3. Search Podcast");
                    System.out.println("4. Exit");
                    int choice2 = scanner.nextInt();
                    System.out.println("---------------------------------------");
                    PodcastImpl obj2 = new PodcastImpl();
                    switch (choice2) {
                        case 1:
                            System.out.println("List of all Podcasts");
                            System.out.println("---------------------------------");
                            List<Podcast> allPodcast = obj2.displayAllPodcasts();
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.format("%10s %10s %10s %10s %10s %40s %60s \n","Podcast_name","Podcast_id","Podcast_duration","Podcast_episode","Podcast_lang","Podcast_file_path","Playlist_id");
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            for (Podcast s : allPodcast) {
                                System.out.format("%10s %10d %10s %10s %10s %40s %10s \n",s.getPodcast_name(),s.getPodcast_id(),s.getPodcast_duration(),s.getPodcast_episode(),s.getPodcast_lang(),s.getPodcast_file_path(),s.getPlaylist_id());
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


                            }
                            break;
                        case 2:
                            System.out.println("All Podcasts in order");
                            System.out.println("-------------------------");
                            List<Podcast> sorted = obj2.sort_Podcasts();
                            for (Podcast s : sorted) {
                                System.out.format("%10s %10d %10s %10s %10s %40s %10d \n",s.getPodcast_name(),s.getPodcast_id(),s.getPodcast_duration(),s.getPodcast_episode(),s.getPodcast_lang(),s.getPodcast_file_path(),s.getPlaylist_id());
                                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            }
                            break;
                        case 3:
                            System.out.println("Enter the Podcast ID : ");
                            int id = scanner.nextInt();
                            System.out.println("---------------------------");
                            Podcast podcast=obj2.search_podcasts(id);
                            System.out.println(podcast);
                            break;
                        case 4:
                            System.exit(0);
                    }
                }

                if (choice1 == 3) {
                    System.out.println("1. Display all playlist");
                    System.out.println("2. Sort Playlist");
                    System.out.println("3. Add Playlist");
                    System.out.println("4. Play Song from Playlist");
                    System.out.println("5. Exit");
                    int choice2 = scanner.nextInt();
                    System.out.println("------------------------------------");
                    PlaylistImpl obj2 = new PlaylistImpl();
                    switch (choice2) {
                        case 1:
                            System.out.println("List of Playlists");
                            System.out.println("---------------------------");
                            List<Playlist> allPlaylistDets = obj2.DisplayAllPlaylist();
                            for (Playlist s : allPlaylistDets) {
                                System.out.format("%10d %20s %10s\n",s.getPlaylist_id(),s.getPlaylist_name(),s.getUserid());
                                System.out.println("------------------------------------------------------------------------");
                            }
                            break;
                        case 2:
                            System.out.println("set the playlist in order");
                            System.out.println("-----------------------------");
                            List<Playlist> sorted = obj2.sortPlayList();
                            for (Playlist s : sorted) {
                                System.out.println(s.getPlaylist_id() + "\t" + s.getPlaylist_name() + "\t" + s.getUserid());
                                System.out.println("--------------------------------------------------------------------------");
                            }
                        case 3:
                            System.out.println("Add Your PlayList");
                            System.out.println("-------------------------------");
                            boolean flag1 = obj2.addPlaylist();
                        case 4:
                            System.out.println("play song what u want from playlist");
                            System.out.println("-----------------------------------");
                            obj2.playSongInPlaylist();
                            break;

                        case 5 :
                            System.exit(0);
                    }
                }
                if(choice1==4){
                    System.out.println("1. Play Song");
                    System.out.println("2. Exit");
                    int choice3=scanner.nextInt();
                    System.out.println("--------------------");
                    SongsImpl obj3=new SongsImpl();
                    switch (choice3){
                        case 1 :
                            System.out.println("------Enjoy the music------");
                            System.out.println("------------------------------");
                           obj3.playSong();
                          break;
                        case 2 :
                            System.exit(0);
                    }
                }
                if(choice1==5){
                    System.out.println("1. Play Podcast :");
                    System.out.println("2. Exit");
                    int choice4=scanner.nextInt();
                    System.out.println("-----------------------------");
                    PodcastImpl obj4=new PodcastImpl();
                    switch (choice4){
                        case 1 :
                            System.out.println("------ENJOY THE MUSIC--------");
                            System.out.println("-------------------------------");
                            obj4.play_Podcast();
                            break;
                        case 2 :
                            System.exit(0);
                    }
                }
                if(choice1==6){
                    System.out.println("U WANT TO EXIT");
                    System.out.println("1. YES");
                    System.out.println("2. No");
                    int choice5=scanner.nextInt();
                    System.out.println("------------------------------------");
                    switch (choice5){
                        case 1 :
                            System.exit(0);
                        case 2 :
                            break;
                    }
                }
            }
        }
    }
}