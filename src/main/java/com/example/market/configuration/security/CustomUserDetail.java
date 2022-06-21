package com.example.market.configuration.security;

import com.example.market.model.odamboy.User;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@ToString
public class CustomUserDetail implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private boolean enable;

    private List<GrantedAuthority>authorityList;

    public CustomUserDetail(User user){
        id =user.getId();
        username = user.getUsername();
        password = user.getPassword();
        enable =user.getStatus();

        this.authorityList =List.of(new SimpleGrantedAuthority(user.getUserType().getName()));

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
    public int getId(){
        return id;

    }
}
