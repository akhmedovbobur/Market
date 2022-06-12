package com.example.market.service.hasanboy;

import com.example.market.model.hasanboy.Models;
import com.example.market.repository.hasanboy.BrandsRepository;
import com.example.market.exception.MarketException;
import com.example.market.dto.hasanboy.BrandsDto;
import com.example.market.model.hasanboy.Brands;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandsService {
    private BrandsRepository brandsRepository;
    public boolean create(BrandsDto dto) {
        Brands brands = new Brands();
        brands.setId(dto.getId());
        brands.setName(dto.getName());
        brands.setStatus(true);
        brands.setCreatedAt(LocalDateTime.now());
        brandsRepository.save(brands);
        return true;
    }

    public BrandsDto get(Integer id) {
        Brands models = getEntity(id);
        BrandsDto dto = new BrandsDto();
        models.setName(dto.getName());
        return dto;
    }

    public boolean update(Integer id, BrandsDto dto) {
        Brands brands = getEntity(id);
        brands.setName(dto.getName());
        brands.setUpdatedAt(LocalDateTime.now());
        brandsRepository.save(brands);
        return true;
    }

    public boolean delete(Integer id) {
        Brands brands = getEntity(id);
        brands.setDeletedAt(LocalDateTime.now());
        brandsRepository.save(brands);
        return true;
    }

    private Brands getEntity(Integer id) {
        Optional<Brands> optional = brandsRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new MarketException("Brand Not Found");
        }
        return optional.get();
    }
}
