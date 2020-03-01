package com.minhchauptit.scoremanagement.util.bean;

import com.minhchauptit.scoremanagement.dto.AccountDTO;
import com.minhchauptit.scoremanagement.entity.Account;

public class AccountBeanUtil {

    public static AccountDTO entity2DTO(Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setUsername(account.getUsername());
        accountDTO.setPassword(account.getPassword());
        accountDTO.setAvatar(account.getAvatar());
        accountDTO.setEmail(account.getEmail());
        return accountDTO;
    }

    public static Account dto2Entity(AccountDTO accountDTO){
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setUsername(accountDTO.getUsername());
        account.setAvatar(accountDTO.getAvatar());
        account.setEmail(accountDTO.getEmail());
        account.setPassword(accountDTO.getPassword());
        return account;
    }

}
