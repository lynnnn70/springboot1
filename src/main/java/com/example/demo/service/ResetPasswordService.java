package com.example.demo.service;


import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordService {

    //修改
    @Autowired
    private AccountRepository accountRepository;

}
