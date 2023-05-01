package DAOinterface;

import model.Song;
import java.util.List;

public interface SongsInterface {
    List<Song> displayAllSongs();
    List<Song> sortSongs();

    Song searchSong(int songId);
    void playSong();
    List<Song> sortGenre();
    List<Song> searchgenre(String genre);
    void AddSongToPlaylist();

}
