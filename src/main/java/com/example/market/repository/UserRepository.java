package com.example.market.repository;

import com.example.market.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    Optional<User> findByIdAndDeletedAtIsNull(Integer id);
    Optional<User> findByEmailAndDeletedAtIsNull(String username);
    Optional<User> findByEmailOrContactAndDeletedAtIsNull(String email, String contact);
    Optional<User> findByEmailAndPasswordAndDeletedAtIsNull(String email, String password);
}

