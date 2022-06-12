package com.example.market.service.hasanboy;

import com.example.market.dto.hasanboy.BodyTypesDto;
import com.example.market.exception.MarketException;
import com.example.market.model.hasanboy.BodyTypes;
import com.example.market.repository.hasanboy.BodyTypesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BodyTypesService {
    private BodyTypesRepository bodyTypesRepository;

    public boolean create(BodyTypesDto dto) {
        BodyTypes bodyTypes = new BodyTypes();
        bodyTypes.setId(dto.getId());
        bodyTypes.setName(dto.getName());
        bodyTypes.setCreatedAt(LocalDateTime.now());
        bodyTypesRepository.save(bodyTypes);
        return true;
    }

    public BodyTypesDto get(Integer id) {
        BodyTypes bodyTypes = getEntity(id);
        BodyTypesDto dto = new BodyTypesDto();
        bodyTypes.setName(dto.getName());
        return dto;
    }

    public boolean update(Integer id, BodyTypesDto dto) {
        BodyTypes bodyTypes = getEntity(id);
        bodyTypes.setName(dto.getName());
        bodyTypes.setUpdatedAt(LocalDateTime.now());
        bodyTypesRepository.save(bodyTypes);
        return true;
    }

    public boolean delete(Integer id) {
        BodyTypes bodyTypes = getEntity(id);
        bodyTypes.setDeletedAt(LocalDateTime.now());
        return true;
    }

    private BodyTypes getEntity(Integer id) {
        Optional<BodyTypes> optional = bodyTypesRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new MarketException("Model Type Not Found");
        }
        return optional.get();
    }
}
