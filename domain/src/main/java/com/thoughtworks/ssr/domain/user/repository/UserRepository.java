package com.thoughtworks.ssr.domain.user.repository;

import com.thoughtworks.ssr.domain.user.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> createUser(User user);

    Optional<User> updateUser(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
