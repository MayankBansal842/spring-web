package com.example.SpringWebApplication.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        return username.equals("mayank") && password.equals("pass");

    }
}
