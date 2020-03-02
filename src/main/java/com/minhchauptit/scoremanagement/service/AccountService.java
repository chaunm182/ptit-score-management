package com.minhchauptit.scoremanagement.service;

import com.minhchauptit.scoremanagement.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account findById(Integer id);
    Account findByUsername(String username);
    void save(Account account);
}
