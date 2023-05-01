package com.example.userapplication.TokenGenerator;

import com.example.userapplication.model.User;

import java.util.Map;

public interface JwtService {
    public abstract Map<String,String> Generate(User user);
}
