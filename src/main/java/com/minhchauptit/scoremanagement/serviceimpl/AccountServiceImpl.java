package com.minhchauptit.scoremanagement.serviceimpl;

import com.minhchauptit.scoremanagement.account.MyAccount;
import com.minhchauptit.scoremanagement.entity.Account;
import com.minhchauptit.scoremanagement.entity.Role;
import com.minhchauptit.scoremanagement.repository.AccountRepository;
import com.minhchauptit.scoremanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Account> optional = accountRepository.findAccountByUsername(s);
        if(!optional.isPresent()) throw new UsernameNotFoundException("User not found - username: "+s);
        Account account = optional.get();
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        Set<Role> roles = account.getRoles();
        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new MyAccount(account.getUsername(),account.getPassword(),authorities,account.getEnable());
    }

    @Override
    public Account findById(Integer id) {
        Optional<Account> optional =  accountRepository.findById(id);
        if(optional.isPresent()) return optional.get();
        return null;
    }

    @Override
    public Account findByUsername(String username) {
        Optional<Account> optional =  accountRepository.findAccountByUsername(username);
        if(optional.isPresent()) return optional.get();
        return null;
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }


}
