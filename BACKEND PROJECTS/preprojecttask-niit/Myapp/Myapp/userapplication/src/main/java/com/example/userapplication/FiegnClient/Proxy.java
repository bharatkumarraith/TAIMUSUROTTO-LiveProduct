package com.example.userapplication.FiegnClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name ="spotifyapp",url ="localhost:9999")
public interface Proxy {
    @PostMapping("/spotify-app/adduser")
    public abstract ResponseEntity<?> sendDataToSpotify(@RequestBody UserDTO userDTO);
}
