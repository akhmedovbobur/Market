package com.example.market.repository.azamat;

import com.example.market.model.azamat.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MerchantsRepository extends JpaRepository<Merchants, Integer>, JpaSpecificationExecutor<Merchants> {
    Optional<Merchants> findByIdAndDeletedAtIsNull(Integer id);
}
