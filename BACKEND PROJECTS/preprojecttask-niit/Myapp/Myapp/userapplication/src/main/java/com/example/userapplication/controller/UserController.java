package com.example.userapplication.controller;

import com.example.userapplication.Exceptions.UserAlreadyExistsException;
import com.example.userapplication.FiegnClient.SignUpData;
import com.example.userapplication.TokenGenerator.JwtService;
import com.example.userapplication.model.User;
import com.example.userapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user-app")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

//http://localhost:9000/user-app/register-user
    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser1(@RequestBody SignUpData signUpData) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.register1(signUpData), HttpStatus.OK);
    }

    //http://localhost:9000/user-app/check-Login
    @PostMapping ("/check-Login")
    public ResponseEntity<?> checkLogin(@RequestBody User user )
    {
        User result=userService.CheckLogin(user.getEmailId(),user.getPassword());
        System.out.println(result);
        if (result!=null)
        {

            return new ResponseEntity<>(jwtService.Generate(result),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("LoginFailed",HttpStatus.OK);
        }
    }
}
