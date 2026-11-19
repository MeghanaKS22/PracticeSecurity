package com.practice.practiceSecurity.service;

import com.practice.practiceSecurity.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class loginService {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    public String authenticateAndGenerateToken(String username, String password) throws AuthenticationException {
        Authentication authentication = authManager.
                authenticate(new UsernamePasswordAuthenticationToken(username, password));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(username);
        }
        return null;
    }
}