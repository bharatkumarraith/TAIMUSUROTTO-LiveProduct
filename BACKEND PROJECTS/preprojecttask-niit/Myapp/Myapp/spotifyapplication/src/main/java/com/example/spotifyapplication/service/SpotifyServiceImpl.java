package com.example.spotifyapplication.service;

import com.example.spotifyapplication.exception.UserAlreadyExists;
import com.example.spotifyapplication.model.Song;
import com.example.spotifyapplication.model.User;
import com.example.spotifyapplication.repository.SongRepository;
import com.example.spotifyapplication.repository.SpotifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotifyServiceImpl implements SpotifyService{
    @Autowired
    private SpotifyRepository spotifyRepository;
    @Autowired
    private SongRepository songRepository;
    @Override
    public User AddUser(User user) throws UserAlreadyExists {
        if (spotifyRepository.findById(user.getEmailId()).isEmpty())
        {
            return spotifyRepository.save(user);
        }
        else {
            throw new UserAlreadyExists();
        }
    }

    @Override
    public User GetUserDetails(String emailId) {
        return spotifyRepository.findById(emailId).get();
    }

    @Override
    public User AddSongs(Song song, String emid) {
        User u1=spotifyRepository.findById(emid).get();
        u1.getSongs().add(song);
        return spotifyRepository.save(u1);
    }

    @Override
    public List<Song> displayAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song addSong(Song song) {
        return songRepository.save(song);
    }
}
