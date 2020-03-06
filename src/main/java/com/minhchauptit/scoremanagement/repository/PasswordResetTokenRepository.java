package com.minhchauptit.scoremanagement.repository;

import com.minhchauptit.scoremanagement.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Integer> {
    Optional<PasswordResetToken> findFirstByToken(String token);
}
