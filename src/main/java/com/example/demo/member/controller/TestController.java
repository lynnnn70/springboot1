package com.example.demo.member.controller;

import com.example.demo.member.entity.Account;
import com.example.demo.member.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestController {
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("test")
    public Account test(){

        return accountRepository.getByUserAccount("test123");
    }
}
