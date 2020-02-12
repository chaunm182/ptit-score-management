package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {
     Optional<Account> findAccountByUsername(String username);
}
