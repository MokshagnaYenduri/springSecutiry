package com.moksha.securityWithoutEncryption.service;

import com.moksha.securityWithoutEncryption.model.Users;
import com.moksha.securityWithoutEncryption.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    @Autowired
    private AuthenticationManager auth;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(Users user) {
        Authentication aut;
        aut = auth.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));

        if(aut.isAuthenticated()) return "success";
        return "fail";
    }
}