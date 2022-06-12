package com.example.market.service.hasanboy;

import com.example.market.dto.hasanboy.ModelsDto;
import com.example.market.exception.MarketException;
import com.example.market.model.hasanboy.Brands;
import com.example.market.model.hasanboy.Models;
import com.example.market.repository.hasanboy.ModelsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelsService {

    private ModelsRepository modelsRepository;

    public boolean create(ModelsDto dto) {
        Models models = new Models();
        models.setName(dto.getName());
        models.setBrandId(dto.getBrandId());
        models.setStatus(true);
        models.setCreatedAt(LocalDateTime.now());
        modelsRepository.save(models);
        return true;
    }

    public ModelsDto get(Integer id) {
        Models models = getEntity(id);
        ModelsDto dto = new ModelsDto();
        models.setBrandId(dto.getBrandId());
        models.setName(dto.getName());
        return dto;
    }

    public boolean update(Integer id, ModelsDto dto) {
        Models models = getEntity(id);
        models.setName(dto.getName());
        models.setBrandId(dto.getBrandId());
        models.setUpdatedAt(LocalDateTime.now());
        modelsRepository.save(models);
        return true;
    }

    public boolean delete(Integer id) {
        Models models = getEntity(id);
        models.setDeletedAt(LocalDateTime.now());
        modelsRepository.save(models);
        return true;
    }

    private Models getEntity(Integer id) {
        Optional<Models> optional = modelsRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new MarketException("Model Not Found");
        }
        return optional.get();
    }
}
