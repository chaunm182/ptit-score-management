package com.minhchauptit.scoremanagement.service;

import com.minhchauptit.scoremanagement.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    void save(PasswordResetToken passwordResetToken);
    PasswordResetToken findByToken(String token);
}
