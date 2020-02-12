package com.minhchauptit.scoremanagement.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class MyAccount implements UserDetails {

    private String username;
    private String password;
    private Set<GrantedAuthority> authorities;
    private Boolean enable;

    public MyAccount() {
    }

    public MyAccount(String username, String password, Set<GrantedAuthority> authorities, Boolean enable) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enable = enable;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }


    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        return this.enable;
    }
}
