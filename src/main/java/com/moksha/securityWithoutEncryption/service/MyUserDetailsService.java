package com.moksha.securityWithoutEncryption.service;

import ch.qos.logback.core.CoreConstants;
import com.moksha.securityWithoutEncryption.model.UserPrincipal;
import com.moksha.securityWithoutEncryption.model.Users;
import com.moksha.securityWithoutEncryption.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByName(username);
        if(user == null){
            System.out.println("Username not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserPrincipal(user);
    }
}
