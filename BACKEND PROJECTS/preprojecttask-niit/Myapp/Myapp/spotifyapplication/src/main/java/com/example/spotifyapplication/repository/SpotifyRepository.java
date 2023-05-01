package com.example.spotifyapplication.repository;

import com.example.spotifyapplication.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpotifyRepository extends MongoRepository<User,String> {
}
