package DAOinterface;
import model.Podcast;
import java.util.List;

public interface PodcastInterface {
    List<Podcast> displayAllPodcasts();

    List<Podcast> sort_Podcasts();

    Podcast search_podcasts(int podcast_id);

    void play_Podcast();
}
