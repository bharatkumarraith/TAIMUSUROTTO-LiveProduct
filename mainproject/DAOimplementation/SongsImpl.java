package DAOimplementation;

import DAOinterface.SongsInterface;
import model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongsImpl implements SongsInterface {
    DBConnection con=new DBConnection();
    @Override
    public List<Song> displayAllSongs() {

        Connection conn=con.GetConnection();
        List<Song> allSongs=new ArrayList<>();
        Song s=null;
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from song");
            while (rs.next()){
                s=new Song();
                s.setSong_name(rs.getString(1));
                s.setSong_id(rs.getInt(2));
                s.setSong_duration(rs.getString(3));
                s.setArtist(rs.getString(4));
                s.setGenre(rs.getString(5));
                s.setSong_file_path(rs.getString(6));
                s.setPlaylist_id(rs.getInt(7));
                allSongs.add(s);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return allSongs;
    }


    @Override
    public List<Song> sortSongs() {
        Connection conn=con.GetConnection();
        List<Song> sortsong=new ArrayList<>();
        Song sortingsong=null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from song order by songname");
            while (rs.next()) {
                sortingsong = new Song();
                sortingsong.setSong_name(rs.getString(1));
                sortingsong.setSong_id(rs.getInt(2));
                sortingsong.setSong_duration(rs.getString(3));
                sortingsong.setArtist(rs.getString(4));
                sortingsong.setGenre(rs.getString(5));
                sortingsong.setSong_file_path(rs.getString(6));
                sortingsong.setPlaylist_id(rs.getInt(7));
                sortsong.add(sortingsong);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return sortsong;
    }
    @Override
    public Song searchSong(int song_id) {
        Connection conn=con.GetConnection();
        Song searchsong=null;
        try {
            PreparedStatement pr = conn.prepareStatement("Select * from song where songid=?");
            pr.setInt(1,song_id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                searchsong = new Song();
                searchsong.setSong_name(rs.getString(1));
                searchsong.setSong_id(rs.getInt(2));
                searchsong.setSong_duration(rs.getString(3));
                searchsong.setArtist(rs.getString(4));
                searchsong.setGenre(rs.getString(5));
                searchsong.setSong_file_path(rs.getString(6));
                searchsong.setPlaylist_id(rs.getInt(7));

            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return searchsong;
    }
    @Override
   public List<Song> sortGenre()
    {
        List<Song>song=new ArrayList<>();
       Connection conn=con.GetConnection();

       try {
           Statement st = conn.createStatement();
           ResultSet rs= st.executeQuery("select * from song order by genere");
           while (rs.next())
           {
               Song sortgenre=new Song();
               sortgenre.setSong_name(rs.getString(1));
               sortgenre.setSong_id(rs.getInt(2));
               sortgenre.setSong_duration(rs.getString(3));
               sortgenre.setArtist(rs.getString(4));
               sortgenre.setGenre(rs.getString(5));
               sortgenre.setSong_file_path(rs.getString(6));
               sortgenre.setPlaylist_id(rs.getInt(7));
               song.add(sortgenre);
           }
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
       return song;
    }

    @Override
    public List<Song> searchgenre(String genre) {
        List<Song>songs=new ArrayList<>();
        Connection conn=con.GetConnection();
        Song searchsong=null;
        try {
            PreparedStatement pr = conn.prepareStatement("Select * from song where genere=?");
            pr.setString(1, String.valueOf(genre));
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                searchsong = new Song();
                searchsong.setSong_name(rs.getString(1));
                searchsong.setSong_id(rs.getInt(2));
                searchsong.setSong_duration(rs.getString(3));
                searchsong.setArtist(rs.getString(4));
                searchsong.setGenre(rs.getString(5));
                searchsong.setSong_file_path(rs.getString(6));
                searchsong.setPlaylist_id(rs.getInt(7));
                songs.add(searchsong);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
          return songs;
    }

    @Override
    public void AddSongToPlaylist() {
        DBConnection con=new DBConnection();
        Connection conn=con.GetConnection();
        System.out.println("enter the songid");
        Scanner scanner=new Scanner(System.in);
        int songid=scanner.nextInt();
        System.out.println("enter the playlistid");
        int playlistid=scanner.nextInt();
        try{
            String sql= "update song set playlistid=? where songid=?";

            PreparedStatement st=conn.prepareStatement(sql);
            st.setInt(1,playlistid);
            st.setInt(2,songid);
            int rows= st.executeUpdate();
            System.out.println("sucessfully added");

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void playSong() {
        DBConnection con=new DBConnection();
        Connection conn=con.GetConnection();
        playsong playSongs=new playsong();
        System.out.println("Enter the playlist id :");
        Scanner sc2 = new Scanner(System.in);
        int id = sc2.nextInt();
        try {

            PreparedStatement pr = conn.prepareStatement("Select songfilepath from song where playlistid=?");
            pr.setInt(1, id);
            ResultSet rs= pr.executeQuery();
            while(rs.next())
            {
                playSongs.readAudio(rs.getString(1),1);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }

    }

}

