package com.moksha.securityWithoutEncryption.repo;

import com.moksha.securityWithoutEncryption.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByName(String username);
}