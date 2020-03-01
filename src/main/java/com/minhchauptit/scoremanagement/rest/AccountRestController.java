package com.minhchauptit.scoremanagement.rest;



import com.minhchauptit.scoremanagement.account.MyAccount;
import com.minhchauptit.scoremanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    public Boolean checkPassword(@RequestBody String password){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyAccount account = (MyAccount) authentication.getPrincipal();
        String storePassword = account.getPassword();
        return passwordEncoder.matches(password,storePassword) ? true : false;
    }
}
