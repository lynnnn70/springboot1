package com.example.demo.member.controller;

import com.example.demo.member.dto.CommonResponse;
import com.example.demo.member.dto.LoginDTO;

import com.example.demo.member.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    //會員登入
    //帳號密碼是否為空
    @PostMapping("login")
    public ResponseEntity<CommonResponse> login(@RequestBody LoginDTO loginDTO){
        if(loginDTO.getUserAccount() == null){
            CommonResponse response = new CommonResponse("Login Failed");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }if(loginDTO.getPassword() == null){
            CommonResponse response = new CommonResponse("Login Failed");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
//        LoginDTO login = LoginService.login();
        CommonResponse response = new CommonResponse("Login Successful");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //會員登出






}
