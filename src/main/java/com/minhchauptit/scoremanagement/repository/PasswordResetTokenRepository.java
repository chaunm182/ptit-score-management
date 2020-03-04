package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Integer> {

}
