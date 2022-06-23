package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    boolean existsByUsername(String username);

    boolean existsByEmailAddress(String emailAddress);

    Users findUserByUsernameAndPassword(String username, String password);
}
