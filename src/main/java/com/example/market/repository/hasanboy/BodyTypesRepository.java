package com.example.market.repository.hasanboy;

import com.example.market.model.hasanboy.BodyTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BodyTypesRepository extends JpaRepository<BodyTypes, Integer> {
    Optional<BodyTypes> findByIdAndDeletedAtIsNull(Integer id);
}
