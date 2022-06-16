package com.example.market.configuration.security;

import com.example.market.model.odamboy.User;
import com.example.market.model.odamboy.UserType;
import com.example.market.repository.odamboy.UserRepository;
import com.example.market.service.odamboy.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService  implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserTypeService userTypeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional =this.userRepository.findByUsername(username);
        if (userOptional.isEmpty()){
            throw new UsernameNotFoundException("Username not found");
        }
        User user=userOptional.get();
        UserType userType =userTypeService.getUserTypeEntity(user.getId());
        user.setUserType(userType);
        return new CustomUserDetail(user);
    }
}
