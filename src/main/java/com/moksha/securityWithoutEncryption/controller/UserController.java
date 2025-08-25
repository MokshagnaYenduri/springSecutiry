package com.moksha.securityWithoutEncryption.controller;

import com.moksha.securityWithoutEncryption.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public Users user;


}
