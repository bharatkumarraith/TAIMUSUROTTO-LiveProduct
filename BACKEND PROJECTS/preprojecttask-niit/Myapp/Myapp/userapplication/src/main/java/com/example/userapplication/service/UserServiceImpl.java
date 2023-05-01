package com.example.userapplication.service;

import com.example.userapplication.Exceptions.UserAlreadyExistsException;
import com.example.userapplication.FiegnClient.Proxy;
import com.example.userapplication.FiegnClient.SignUpData;
import com.example.userapplication.FiegnClient.UserDTO;
import com.example.userapplication.model.User;
import com.example.userapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Proxy proxy;
    @Override
    public User CheckLogin(String emailId, String password) {
        return userRepository.findByEmailIdAndPassword(emailId,password);
    }

    @Override
    public User register1(SignUpData signUpData) throws UserAlreadyExistsException {
        UserDTO userDTO= new UserDTO(signUpData.getEmailId(),signUpData.getName(),signUpData.getAddress());
        ResponseEntity responseEntity= proxy.sendDataToSpotify(userDTO);
        System.out.println(responseEntity);
        User user= new User(signUpData.getEmailId(),signUpData.getPassword(),"role_user");
        return userRepository.save(user);
    }
}
