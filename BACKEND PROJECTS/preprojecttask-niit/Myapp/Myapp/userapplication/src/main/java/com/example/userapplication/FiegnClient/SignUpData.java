package com.example.userapplication.FiegnClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpData {
    private String emailId;
    private String password;
    private String name;
    private String address;
}
