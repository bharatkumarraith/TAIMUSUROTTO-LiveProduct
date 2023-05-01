package com.example.spotifyapplication.service;

import com.example.spotifyapplication.exception.UserAlreadyExists;
import com.example.spotifyapplication.model.Song;
import com.example.spotifyapplication.model.User;

import java.util.List;

public interface SpotifyService {
    User AddUser(User user) throws UserAlreadyExists;
    public abstract User GetUserDetails(String emailId);
    public abstract User AddSongs(Song song, String emid);
    public abstract List<Song> displayAllSongs();
    public abstract Song addSong(Song song);
}
