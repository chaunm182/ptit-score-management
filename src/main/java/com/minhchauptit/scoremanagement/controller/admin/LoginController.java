package com.minhchauptit.scoremanagement.controller.admin;

import com.minhchauptit.scoremanagement.entity.Account;
import com.minhchauptit.scoremanagement.entity.PasswordResetToken;
import com.minhchauptit.scoremanagement.service.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private PasswordResetTokenService passwordResetTokenService;

    @GetMapping("/login")
    public String showLoginPage(){
        return "view/admin/login";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "view/admin/access-denied";
    }

    @GetMapping("/forgot-password")
    public String showForgotPasswordPage(){
        return "view/admin/forgot-password";
    }

    @GetMapping("/reset-password")
    public String showResetPasswordPage(@RequestParam("token") String token, Model model){
        PasswordResetToken resetToken = passwordResetTokenService.findByToken(token);
        if(resetToken!=null){

            Date expiryDate = resetToken.getExpiryDate();
            Date now = new Date();
            if(now.getTime()-expiryDate.getTime()<0){
                Account account = resetToken.getAccount();
                model.addAttribute("account",account);
            }
            return "view/admin/reset-password";
        }
        return "view/admin/404";

    }
}
