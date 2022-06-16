package com.example.market.repository.odamboy;

import com.example.market.model.odamboy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameAndPassword(String email, String password);

    Optional<User> findByUsername(String username);

    List<User> findAllByDeletedAtIsNull();
}

