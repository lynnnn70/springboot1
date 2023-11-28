package com.example.demo.member.service;

import com.example.demo.member.dto.RegisterResult;
import com.example.demo.member.entity.Account;
import com.example.demo.member.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private AccountRepository accountRepository;

    //驗證使用者帳號是否重複
    //驗證email是否重複 返回一個空的Optional

//    public Optional<Account> register(Account account){
//        if(checkAccount(account)){
//            return Optional.empty();
//        }
//        account = accountRepository.save(account);
//        return Optional.of(account);
//    }
    private boolean checkAccount (Account account){
        return accountRepository.findByEmail(account.getEmail()).isPresent() || accountRepository.findByUserAccount(account.getUserAccount()).isPresent();
    }

    //分開check不能直接存
    //可以自定義一個物件回傳code...或自定義exception
    //如果userAccount存在，回傳一個-11 code
    //如果Email存在，回傳一個-12 code
    //如果都不存在 save

    public RegisterResult register(Account account){
        if(checkUserAccount(account)){
            return new RegisterResult(-11);
        }else if(checkEmail(account)){
            return new RegisterResult(-12);
        }else if(checkAccount(account))
            account = accountRepository.save(account);
            return new RegisterResult(0);
    }


    public boolean checkUserAccount(Account account) {
        return (accountRepository.findByUserAccount(account.getUserAccount()).isPresent());
    }

    public boolean checkEmail(Account account){
        return (accountRepository.findByEmail(account.getEmail()).isPresent());
    }
}

