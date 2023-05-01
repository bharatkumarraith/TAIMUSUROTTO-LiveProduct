package com.example.spotifyapplication.controller;

import com.example.spotifyapplication.exception.UserAlreadyExists;
import com.example.spotifyapplication.model.Song;
import com.example.spotifyapplication.model.User;
import com.example.spotifyapplication.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/spotify-app")
public class SpotifyController {
    @Autowired
    private SpotifyService spotifyService;

//http://localhost:9999/spotify-app/adduser
      @PostMapping("/adduser")
    public ResponseEntity<?> AddUser(@RequestBody User user) throws UserAlreadyExists {
        try {
            user.setSongs(new ArrayList<>());
            return new ResponseEntity<>(spotifyService.AddUser(user), HttpStatus.OK);
        } catch (UserAlreadyExists ex) {
            throw new UserAlreadyExists();
        }

    }
//http://localhost:9999/spotify-app/get-User-Details
    @GetMapping("/get-User-Details")
    public ResponseEntity<?>getUserDetails(HttpServletRequest httpServletRequest)
    {
        String currentEmail=(String)httpServletRequest.getAttribute("currentEmail");
        System.out.println(currentEmail);
        return new ResponseEntity<>(spotifyService.GetUserDetails(currentEmail),HttpStatus.OK);
    }
//http://localhost:9999/spotify-app/add-song-to-playlist
    @PostMapping("/add-song-to-playlist")
    public ResponseEntity<?>addSongToPlaylist(@RequestBody Song song, HttpServletRequest httpServletRequest)
    {
        String currentEmail=(String)httpServletRequest.getAttribute("currentEmail");
        System.out.println(currentEmail);

        return new ResponseEntity<>(spotifyService.AddSongs(song,currentEmail),HttpStatus.OK);
    }

    //http://localhost:9999/spotify-app/displayAllSongs
    @GetMapping("/displayAllSongs")
    public ResponseEntity<?> displayAllSongs()
    {
        return new ResponseEntity<>(spotifyService.displayAllSongs(),HttpStatus.OK);
    }

    //http://localhost:9999/spotify-app/addsong
    @PostMapping("/addsong")
    public ResponseEntity<?>addSong(@RequestBody Song song)
    {
        return new ResponseEntity<>(spotifyService.addSong(song),HttpStatus.OK);
    }

}
