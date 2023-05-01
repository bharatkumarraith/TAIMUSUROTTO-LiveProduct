package com.example.userapplication.service;

import com.example.userapplication.Exceptions.UserAlreadyExistsException;
import com.example.userapplication.FiegnClient.SignUpData;
import com.example.userapplication.model.User;

public interface UserService {
    User CheckLogin(String emailId, String password);
    public abstract User register1(SignUpData signUpData)throws UserAlreadyExistsException;
}
