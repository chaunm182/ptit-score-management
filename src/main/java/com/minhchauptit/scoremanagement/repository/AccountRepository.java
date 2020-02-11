package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
