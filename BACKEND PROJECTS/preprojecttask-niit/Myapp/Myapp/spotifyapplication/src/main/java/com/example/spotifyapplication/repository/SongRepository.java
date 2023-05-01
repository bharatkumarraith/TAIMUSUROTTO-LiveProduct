package com.example.spotifyapplication.repository;

import com.example.spotifyapplication.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song,String> {
}
