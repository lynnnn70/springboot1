package com.example.demo.member.controller;

import com.example.demo.member.entity.Account;
import com.example.demo.member.service.ResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ResetPasswordController {

    @Autowired
    private ResetPasswordService resetPasswordService;

    @PostMapping("resetPassword")
    public void resetPassword(@RequestBody Account account){
//        String userA

    }
}
