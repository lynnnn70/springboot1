package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {

    @Autowired
    private AccountRepository accountRepository;

    //驗證使用者帳號是否重複
    //驗證email是否重複 返回一個空的Optional
    public Optional<Account> register(Account account){
        if(checkAccount(account)) {
            return Optional.empty();
        }
        account = accountRepository.save(account);
        return Optional.of(account);
    }
    private boolean checkAccount (Account account){
        return accountRepository.findByEmail(account.getEmail()).isPresent() || accountRepository.findByUserAccount(account.getUserAccount()).isPresent();
    }
}
