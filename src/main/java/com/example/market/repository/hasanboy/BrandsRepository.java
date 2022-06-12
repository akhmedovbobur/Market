package com.example.market.repository.hasanboy;

import com.example.market.model.hasanboy.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandsRepository extends JpaRepository<Brands,Integer> {
    Optional<Brands> findByIdAndDeletedAtIsNull(Integer id);
}
