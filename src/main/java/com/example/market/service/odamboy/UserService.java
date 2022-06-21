package com.example.market.service.odamboy;

import com.example.market.dto.odamboy.UserDto;
import com.example.market.dto.odamboy.UserTypeDto;
import com.example.market.exception.MarketException;
import com.example.market.model.odamboy.User;
import com.example.market.repository.odamboy.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private UserRepository userRepository;
    private UserTypeService userTypeService;
    public UserDto get(Integer id) {
        User entity = getUserEntity(id);
        UserDto userDto = new UserDto();
        userDto = convertEntityToDto(entity, userDto);
        userDto.setUserTypeDto(userTypeService.get(userDto.getUserTYpeId()));
        log.info("Get User Info {}", userDto);
        return userDto;
    }

    public UserDto create(UserDto userDto) {
        //checking email and username
        Optional<User> optional = userRepository.findByUsernameOrEmail(userDto.getUsername(), userDto.getEmail());
        if (optional.isPresent()) {
            throw new MarketException(" User with this email or username already exist ! ");
        }
        User user = new User();
        // Check
        userTypeService.getUserTypeEntity(userDto.getUserTYpeId());
        user = convertDtoToEntity(userDto, user);
        // Because this data is unique
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        log.info("Create User {}", user);
        return userDto;
    }

    public UserDto update(Integer id, UserDto userDto) {
        User user = getUserEntity(id);
        convertDtoToEntity(userDto, user);
        user.setId(id);
        // Because this data is unique
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        log.info("Update User {}", user);
        return userDto;
    }

    public Boolean delete(Integer id) {
        User user = getUserEntity(id);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
        log.info("Delete User {}", user);
        return true;
    }

    public List<UserDto> getAll(){
        List<User> userList = userRepository.findAllByDeletedAtIsNull();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            UserDto userDto = convertEntityToDto(user, new UserDto());
            userDto.setUserTypeDto(userTypeService.convertEntityToDto(userTypeService.getUserTypeEntity(
                    user.getUserTypeId()), new UserTypeDto()));
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    //Secondary functions

    public User getUserEntity(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty() || optional.get().getDeletedAt() != null) {
            throw new MarketException("User does not exist !");
        }
        return optional.get();
    }


    public UserDto convertEntityToDto(User first, UserDto second) {
        second.setId(first.getId());
        second.setUserTYpeId(first.getUserTypeId());
        second.setUsername(first.getUsername());
        second.setPassword(first.getPassword());
        second.setEmail(first.getEmail());
        second.setFirstname(first.getFirstname());
        second.setLastname(first.getLastname());
        second.setAvatar(first.getAvatar());
        second.setPhone(first.getPhone());
        second.setBirth(first.getBirth());
        second.setAddress(first.getAddress());
        second.setAddress2(first.getAddress2());
        second.setCityId(first.getCityId());
        second.setPostcode(first.getPostcode());
        second.setQrCode(first.getQrCode());
        second.setEmailVerifiedAt(first.getEmailVerifiedAt());
        second.setPhoneVerifiedAt(first.getPhoneVerifiedAt());
        second.setCreatedAt(first.getCreatedAt());
        second.setUpdatedAt(first.getUpdatedAt());
        second.setDeletedAt(first.getDeletedAt());
        second.setStatus(first.getStatus());
        return second;
    }

    public User convertDtoToEntity(UserDto first, User second) {
        second.setUserTypeId(first.getUserTYpeId());
        second.setFirstname(first.getFirstname());
        second.setLastname(first.getLastname());
        second.setAvatar(first.getAvatar());
        second.setBirth(first.getBirth());
        second.setAddress(first.getAddress());
        second.setAddress2(first.getAddress2());
        second.setCityId(first.getCityId());
        second.setPostcode(first.getPostcode());
        second.setQrCode(first.getQrCode());
        return second;
    }

    public List<UserDto> getAllForAdmin(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userRepository.findAll(pageable);
        return users.stream().map(user -> convertEntityToDto(user, new UserDto())).collect(Collectors.toList());
    }
    public boolean changeUserToAdmin(Integer id) {
        User user = getUserEntity(id);
        user.setUserTypeId(1);
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return true;
    }

}
