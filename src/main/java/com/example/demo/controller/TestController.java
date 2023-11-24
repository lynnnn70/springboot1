package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class TestController {
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("test")
    public Optional<Account> test(){
        Optional<Account> accountOptional = accountRepository.findById(2);
        if(accountOptional.isPresent()){
            Account account = accountOptional.get();
            account.setName("Wilson");
            accountRepository.save(account);
        }
        return accountRepository.findById(2);

    }
}
