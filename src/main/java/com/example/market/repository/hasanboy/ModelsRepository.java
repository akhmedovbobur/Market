package com.example.market.repository.hasanboy;

import com.example.market.model.hasanboy.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelsRepository extends JpaRepository<Models,Integer> {
    Optional<Models> findByIdAndDeletedAtIsNull(Integer id);
}
