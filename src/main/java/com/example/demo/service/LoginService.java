package com.example.demo.service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private AccountRepository accountRepository;

    //比對是否有此使用者帳號
    //比對帳號密碼是否正確(db裡的帳密跟傳進來的帳密要比對)
    public Optional<Account> login(LoginDTO loginDTO){
        Optional<Account> account = accountRepository.findByUserAccount(loginDTO.getUserAccount());

        if(!checkUserAccount(loginDTO)){
            return Optional.empty();
        }
//       if (){

//       }
        return account;
    }

    public boolean checkUserAccount(LoginDTO loginDTO){
       return accountRepository.findByUserAccount(loginDTO.getUserAccount()).isPresent();
    }
}
