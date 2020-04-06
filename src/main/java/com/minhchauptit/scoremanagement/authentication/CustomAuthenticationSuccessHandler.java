package com.minhchauptit.scoremanagement.authentication;

import com.minhchauptit.scoremanagement.entity.Account;
import com.minhchauptit.scoremanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    private AccountService accountService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("======> Customize authentication success handler");
        String username = authentication.getName();
        Account account = accountService.findByUsername(username);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("account",account);
    }
}
