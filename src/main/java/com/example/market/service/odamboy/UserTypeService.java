package com.example.market.service.odamboy;

import com.example.market.dto.odamboy.UserTypeDto;
import com.example.market.exception.MarketException;
import com.example.market.model.odamboy.UserType;
import com.example.market.repository.odamboy.UserTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserTypeService {
    private UserTypeRepository userTypeRepository;

    public boolean create(UserTypeDto dto){
        UserType userType=new UserType();
        userType.setId(dto.getId());
        userType.setName(dto.getName());
        userType.setDisplayName(dto.getDisplayName());
        userType.setStatus(true);
        userType.setCreatedAt(LocalDateTime.now());
        userTypeRepository.save(userType);
        return true;
    }

    public UserTypeDto get(Integer id){
        UserType userType=getEntity(id);
        UserTypeDto userTypeDto=new UserTypeDto();
        userTypeDto.setId(userTypeDto.getId());
        userTypeDto.setName(userTypeDto.getName());
        userTypeDto.setDisplayName(userTypeDto.getDisplayName());
        userTypeDto.setCreatedAt(LocalDateTime.now());
        userTypeRepository.save(userType);
        return userTypeDto;
    }
    public boolean update(Integer id, UserTypeDto dto){
        UserType userType=getEntity(id);
        userType.setName(dto.getName());
        userType.setDisplayName(dto.getDisplayName());
        userType.setUpdatedAt(LocalDateTime.now());
        userTypeRepository.save(userType);
        return true;
    }

    public boolean delete(Integer id){
        UserType userType=getEntity(id);
        userType.setDeletedAt(LocalDateTime.now());
        userTypeRepository.save(userType);
        return true;
    }
    public UserType getEntity(Integer id){
        Optional<UserType>optional=userTypeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new MarketException("User type not found");
        }
        return optional.get();
    }
}
