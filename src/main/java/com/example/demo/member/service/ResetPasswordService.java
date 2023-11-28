package com.example.demo.member.service;


import com.example.demo.member.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordService {

    //修改
    @Autowired
    private AccountRepository accountRepository;

}
