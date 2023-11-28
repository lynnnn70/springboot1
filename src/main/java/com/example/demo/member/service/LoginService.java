package com.example.demo.member.service;

import com.example.demo.member.dto.LoginDTO;
import com.example.demo.member.entity.Account;
import com.example.demo.member.repository.AccountRepository;
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

        if(!checkAccount(loginDTO)){
            return Optional.empty();
        }
//       if (){

//       }
        return account;
    }

    //用 userAccount(不重複) 拿到整個Account 就可以比對裡面的password
    public boolean checkAccount(LoginDTO loginDTO){
        Account userAccount = accountRepository.getByUserAccount(loginDTO.getUserAccount());
        if(userAccount == null){  // 帳號不存在
            return false;
        }
        String dbPassword = userAccount.getPassword(); // db password
        String dtoPassword = loginDTO.getPassword();
        if(dtoPassword.equals(dbPassword)){
            return true; //login success
        }
        return false;  //password fail
    }


}
