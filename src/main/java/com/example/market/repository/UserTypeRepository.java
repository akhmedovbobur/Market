package com.example.market.repository;

import com.example.market.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    Optional<UserType> findByIdAndDeletedAtIsNull(Integer id);
}
