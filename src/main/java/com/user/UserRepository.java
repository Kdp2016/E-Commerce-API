package com.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {


    boolean existsByEmail(String email);

    Optional<Users> findUserByEmailAndPassword(String email, String password);
}
