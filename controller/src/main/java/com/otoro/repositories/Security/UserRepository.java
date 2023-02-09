package com.otoro.repositories.Security;

import java.util.Optional;

import com.otoro.model.Security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);

    User findUserById(Long id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
