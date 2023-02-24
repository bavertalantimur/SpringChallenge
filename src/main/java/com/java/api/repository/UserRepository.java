package com.java.api.repository;


import com.java.api.user.User;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}