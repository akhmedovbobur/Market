package com.example.market.repository.odamboy;

import com.example.market.model.odamboy.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    Optional<UserType> findByName(String name);
    List<UserType> findAllByDeletedAtIsNull();

}
