package com.minhchauptit.scoremanagement.rest;



import com.minhchauptit.scoremanagement.account.MyAccount;
import com.minhchauptit.scoremanagement.entity.Account;
import com.minhchauptit.scoremanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/account")
public class AccountRestController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/check-password")
    public Boolean checkPassword(@RequestBody String password,HttpServletRequest request){
        HttpSession session = request.getSession();
        String storePassword = ((Account) session.getAttribute("account")).getPassword();
        return passwordEncoder.matches(password,storePassword);
    }

    //change password for current user
    @PostMapping("/change-password")
    public Boolean changePassword(@RequestBody String newPassword, HttpServletRequest request){
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        account.setPassword(passwordEncoder.encode(newPassword));
        try{
            accountService.save(account);
            session.setAttribute("account",account);

        }
        catch (Exception ex){
            return false;
        }
        return true;
    }
}
