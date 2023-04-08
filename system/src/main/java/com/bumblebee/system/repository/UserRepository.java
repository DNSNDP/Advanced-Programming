package com.bumblebee.system.repository;

import com.bumblebee.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);



    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
