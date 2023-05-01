package com.example.userapplication.repository;

import com.example.userapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    public abstract User findByEmailIdAndPassword(String emailId, String password);
}
