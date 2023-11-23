package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.LoginDTO;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class LoginController {

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


}
