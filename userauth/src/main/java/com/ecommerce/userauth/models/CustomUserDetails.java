package com.ecommerce.userauth.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@JsonDeserialize
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {
    private User user;
    public void setAuthorities(List<CustomGrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    private List<CustomGrantedAuthority> authorities;
    public CustomUserDetails(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<CustomGrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for(Role role: user.getRoles()){
//            grantedAuthorities.add(new CustomGrantedAuthority());
//        }
//        Role admin = new Role();
//        admin.setId(1L);
//        admin.setName("ADMIN");
//        grantedAuthorities.add(new CustomGrantedAuthority(admin));
        grantedAuthorities.add(new CustomGrantedAuthority());
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        System.out.println(user.getHashedPassword());
        return user.getHashedPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
        return true;
    }
}