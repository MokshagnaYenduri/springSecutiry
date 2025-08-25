package com.moksha.securityWithoutEncryption.service;

import com.moksha.securityWithoutEncryption.model.Users;
import com.moksha.securityWithoutEncryption.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepo repo;

    public Users register(Users user){
        return repo.save(user);
    }
}
