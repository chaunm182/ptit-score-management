package com.minhchauptit.scoremanagement.serviceimpl;

import com.minhchauptit.scoremanagement.entity.PasswordResetToken;
import com.minhchauptit.scoremanagement.repository.PasswordResetTokenRepository;
import com.minhchauptit.scoremanagement.service.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public void save(PasswordResetToken passwordResetToken) {
        passwordResetTokenRepository.save(passwordResetToken);
    }

    @Override
    public PasswordResetToken findByToken(String token) {

        Optional<PasswordResetToken> passwordResetTokenOptional = passwordResetTokenRepository.findFirstByToken(token);
        if(passwordResetTokenOptional.isPresent()) return passwordResetTokenOptional.get();
        return null;
    }
}
