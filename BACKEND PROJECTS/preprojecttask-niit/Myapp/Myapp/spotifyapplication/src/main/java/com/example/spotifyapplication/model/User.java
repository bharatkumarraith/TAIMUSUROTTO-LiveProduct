package com.example.spotifyapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private String emailId;
    private String name;
    private String address;
    private List<Song>songs;
}
