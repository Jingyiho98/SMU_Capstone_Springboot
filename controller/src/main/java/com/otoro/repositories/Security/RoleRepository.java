package com.otoro.repositories.Security;

import java.util.Optional;

import com.otoro.model.Security.ERole;
import com.otoro.model.Security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
