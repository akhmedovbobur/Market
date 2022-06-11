package com.example.market.service.odamboy;

import com.example.market.dto.odamboy.UserDto;
import com.example.market.exception.UserException;
import com.example.market.model.odamboy.User;
import com.example.market.repository.odamboy.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserTypeService userTypeService;

    public boolean create(UserDto dto){
        Optional<User>optional=userRepository.findByEmailOrContactAndDeletedAtIsNull(dto.getEmail(),dto.getPhone());
        if (optional.isPresent()){
            throw new UserException("User already token");
        }
        User user=new User();
        user.setId(dto.getId());
        user.setCreatedAt(LocalDateTime.now());
        user.setStatus(true);
        userTypeService.get(user.getUserTypeId());
        convertEntityToDto(user,dto);
        userRepository.save(user);
        return true;
    }
    public UserDto get(Integer id){
        User user=getEntity(id);
        UserDto userDto=new UserDto();
        userTypeService.get(userDto.getUserTypeId());
        user.setCreatedAt(LocalDateTime.now());
        convertDtoToEntity(userDto,user);
        userRepository.save(user);
        return userDto;
    }

    public boolean update(Integer id, UserDto dto){
        User update=getEntity(id);
        update.setId(dto.getId());
        update.setUpdatedAt(LocalDateTime.now());
        userTypeService.getEntity(dto.getUserTypeId());
        convertEntityToDto(update, dto);
        userRepository.save(update);
        return true;
    }

    public  boolean delete(Integer id){
        User user=getEntity(id);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
        return true;
    }


    public User getEntity(Integer id){
        Optional<User>optional=userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new UserException("User not found");
        }
        return optional.get();
    }
    public void convertDtoToEntity(UserDto dto, User user){
        user.setUserTypeId(dto.getUserTypeId());
        user.setUserType(dto.getUserType());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        user.setAddress2(dto.getAddress2());
        user.setAvatar(dto.getAvatar());
        user.setBirth(dto.getBirth());
        user.setCityId(dto.getCityId());
        user.setEmailVerifiedAt(dto.getEmailVerifiedAt());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setPhoneVerifiedAt(dto.getPhoneVerifiedAt());
        user.setPostCode(dto.getPostCode());
        user.setToken(dto.getToken());
        user.setUserName(dto.getUserName());
        user.setStatus(true);
    }

    public UserDto convertEntityToDto(User user, UserDto dto){
        dto.setUserTypeId(user.getUserTypeId());
        dto.setUserType(user.getUserType());
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setAddress2(user.getAddress2());
        dto.setAvatar(user.getAvatar());
        dto.setBirth(user.getBirth());
        dto.setCityId(user.getCityId());
        dto.setEmailVerifiedAt(user.getEmailVerifiedAt());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        dto.setPhone(user.getPhone());
        dto.setPhoneVerifiedAt(user.getPhoneVerifiedAt());
        dto.setPostCode(user.getPostCode());
        dto.setToken(user.getToken());
        dto.setUserName(user.getUserName());
        dto.setStatus(true);
        return dto;
    }

    public List<UserDto> getAllForAdmin(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userRepository.findAll(pageable);
        return users.stream().map(user -> convertEntityToDto(user, new UserDto())).collect(Collectors.toList());
    }
    public boolean changeUserToAdmin(Integer id) {
        User user = getEntity(id);
        user.setUserTypeId(1);
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return true;
    }

}
