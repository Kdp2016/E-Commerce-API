package com.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {


    boolean existsByEmail(String email);

    Users findUserByEmailAndPassword(String email, String password);
}
