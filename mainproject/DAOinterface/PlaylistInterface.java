package DAOinterface;
import model.Playlist;
import java.util.List;

public interface PlaylistInterface {
    List<Playlist> DisplayAllPlaylist();
    List<Playlist> sortPlayList();
    boolean addPlaylist();
    void playSongInPlaylist();
}
