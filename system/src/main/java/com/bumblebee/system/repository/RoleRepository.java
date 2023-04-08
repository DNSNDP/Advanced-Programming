package com.bumblebee.system.repository;

import com.bumblebee.system.model.ERole;
import com.bumblebee.system.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);

}
