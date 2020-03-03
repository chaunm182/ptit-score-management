package com.minhchauptit.scoremanagement.rest;


import com.minhchauptit.scoremanagement.entity.Account;
import com.minhchauptit.scoremanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/accounts/check-password")
    public Boolean checkPassword(@RequestBody String password,HttpServletRequest request){
        HttpSession session = request.getSession();
        String storePassword = ((Account) session.getAttribute("account")).getPassword();
        return passwordEncoder.matches(password,storePassword);
    }

    //change password for current user
    @PostMapping("/accounts/change-password")
    public Boolean changePassword(@RequestBody String newPassword, HttpServletRequest request){
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        account.setPassword(passwordEncoder.encode(newPassword));
        try{
            accountService.save(account);
            session.setAttribute("account",account);

        }
        catch (Exception ex){
            logger.warning(ex.getMessage());
            return false;
        }
        return true;
    }

    @PutMapping("/accounts/update-email")
    public Boolean updateEmail(@RequestBody Account account,HttpServletRequest request){
        String email = account.getEmail();
        account = accountService.findById(account.getId());
        account.setEmail(email);
        try{
            accountService.save(account);
            HttpSession session = request.getSession();
            session.setAttribute("account",account);
            return true;
        }catch (Exception ex){
            logger.info(ex.getMessage());
        }
        return false;
    }

}
