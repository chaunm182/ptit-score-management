package com.minhchauptit.scoremanagement.service;

import com.minhchauptit.scoremanagement.mail.ResetPasswordMail;

public interface MailService {
    void sendMail(ResetPasswordMail mail);

}
