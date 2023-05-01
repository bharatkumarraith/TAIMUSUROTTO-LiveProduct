package DAOimplementation;

import DAOinterface.PlaylistInterface;
import model.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistImpl implements PlaylistInterface {
    @Override
    public List<Playlist> DisplayAllPlaylist() {

        DBConnection con=new DBConnection();
        Connection conn=con.GetConnection();
        List<Playlist>display=new ArrayList<>();
        Playlist playlist=null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from playlist");
            while(rs.next())
            {
                playlist=new Playlist();
                playlist.setPlaylist_id(rs.getInt(1));
                playlist.setPlaylist_name(rs.getString(2));
                playlist.setUserid(rs.getString(3));
                display.add(playlist);

            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return display;
    }

    @Override
    public List<Playlist> sortPlayList() {
        DBConnection con=new DBConnection();
        Connection conn=con.GetConnection();
        List<Playlist>sort=new ArrayList<>();
        Playlist playlist=null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from playlist order by playlistname");
            while(rs.next())
            {
                playlist=new Playlist();
                playlist.setPlaylist_id(rs.getInt(1));
                playlist.setPlaylist_name(rs.getString(2));
                playlist.setUserid(rs.getString(3));
                sort.add(playlist);

            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return sort;
    }

    @Override
    public boolean addPlaylist() {
        DBConnection con=new DBConnection();
        Connection conn=con.GetConnection();
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter your playlist_id");
        int playlistid=s1.nextInt();
        System.out.println("Enter your playlist_name");
        String playlistname=s1.next();
        System.out.println("Enter your userid");
        String userid=s1.next();
        try{
            String sql= "insert into playlist(playlistid,playlistname,userplaylistid) values(?,?,?)";

            PreparedStatement st=conn.prepareStatement(sql);
            st.setInt(1,playlistid);
            st.setString(2,playlistname);
            st.setString(3,userid);
            int rows= st.executeUpdate();
            System.out.println("sucessfully added");
            return true;

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;

    }



    @Override
    public void playSongInPlaylist() {
        DBConnection con=new DBConnection();
        Connection conn=con.GetConnection();
        playsong playSongs=new playsong();
        System.out.println("Enter the playlist id ");
        Scanner sc1 = new Scanner(System.in);
        int id = sc1.nextInt();
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

