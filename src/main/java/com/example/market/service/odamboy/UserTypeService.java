package com.example.market.service.odamboy;

import com.example.market.dto.odamboy.UserTypeDto;
import com.example.market.exception.MarketException;
import com.example.market.model.odamboy.UserType;
import com.example.market.repository.odamboy.UserTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;

    public UserTypeDto get(Integer id) {
        UserType entity = getUserTypeEntity(id);
        log.info("Get User Type Info {}", entity);
        return convertEntityToDto(entity, new UserTypeDto());
    }

    public UserTypeDto create(UserTypeDto userTypeDto) {
        UserType userType = convertDtoToEntity(userTypeDto, new UserType());
        userType.setStatus(true);
        userType.setCreatedAt(LocalDateTime.now());
        userTypeRepository.save(userType);
        log.info("Create User Type {}", userType);
        return userTypeDto;
    }

    public UserTypeDto update(Integer id, UserTypeDto userTypeDto){
        UserType userType = getUserTypeEntity(id);
        convertDtoToEntity(userTypeDto, userType);
        userType.setId(id);
        userType.setUpdatedAt(LocalDateTime.now());
        userTypeRepository.save(userType);
        log.info("Update User Type {}", userType);
        return userTypeDto;
    }

    public Boolean delete(Integer id){
        UserType userType = getUserTypeEntity(id);
        userType.setDeletedAt(LocalDateTime.now());
        userTypeRepository.save(userType);
        log.info("Delete User Type {}", userType);
        return true;
    }

    public UserType getUserTypeByName(String name){
        Optional<UserType> optional = userTypeRepository.findByName(name);
        if (optional.isEmpty()){
            throw new MarketException("User type with this name does not exist");
        }
        return optional.get();
    }

    public List<UserTypeDto> getAll(){
        List<UserType> userTypeList = userTypeRepository.findAllByDeletedAtIsNull();
        List<UserTypeDto> userTypeDtoList = new ArrayList<>();
        for (UserType userType : userTypeList) {
            userTypeDtoList.add(convertEntityToDto(userType, new UserTypeDto()));
        }
        return userTypeDtoList;
    }

    //Secondary functions

    public UserType getUserTypeEntity(Integer id) {
        Optional<UserType> optional = userTypeRepository.findById(id);
        if (optional.isEmpty() || optional.get().getDeletedAt() != null || !optional.get().isStatus()) {
            throw new MarketException("UserType does not exist!");
        }
        return optional.get();
    }

    public UserTypeDto convertEntityToDto(UserType first, UserTypeDto second) {
        second.setId(first.getId());
        second.setName(first.getName());
        second.setDisplayName(first.getDisplayName());
        second.setStatus(first.isStatus());
        second.setCreatedAt(first.getCreatedAt());
        second.setUpdatedAt(first.getUpdatedAt());
        second.setDeletedAt(first.getDeletedAt());
        return second;
    }

    private UserType convertDtoToEntity(UserTypeDto first, UserType second) {
        second.setName(first.getName());
        second.setDisplayName(first.getDisplayName());
        return second;
    }
}
