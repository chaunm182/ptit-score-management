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

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private AccountService accountService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("in custom authentication success handler:");
        String username = authentication.getName();
        Account account = accountService.findByUsername(username);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("account",account);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/admin/home");
    }
}
