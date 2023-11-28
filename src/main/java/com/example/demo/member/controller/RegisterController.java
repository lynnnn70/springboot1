package com.example.demo.member.controller;


import com.example.demo.member.dto.RegisterResponse;
import com.example.demo.member.dto.RegisterResult;
import com.example.demo.member.entity.Account;
import com.example.demo.member.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api")
public class RegisterController {

    @Autowired
    private RegisterService registerService;


    //會員註冊
    //驗證使用者帳號格式是否符合
    //驗證使用者密碼格式是否符合
    //驗證使用者姓名格式是否符合
    //驗證email格式是否正確
    //格式正確的話 就再叫用service的方法
//    @PostMapping("register")
//    public ResponseEntity<RegisterResponse> register( @RequestBody Account account){
//        System.out.println(account);
//        if (!isValidEmail(account.getEmail()) || !isValidName(account.getName()) || !isValidPasseord(account.getPassword()) || !isValidUserAccount(account.getUserAccount())){
//            RegisterResponse response = new RegisterResponse(-10,"Wrong Format");
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//        Optional<Account> optionalAccount = registerService.register(account);
//        if(optionalAccount.isPresent()){
//            RegisterResponse response = new RegisterResponse();
//            response.setCode(0);
//            response.setMessage("Register Successful");
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        }
//        RegisterResponse response = new RegisterResponse(-11,"Email 重複");
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }


    public boolean isValidEmail(String email) {
        return email != null && email.matches("\\w+((-\\w+)|(\\.\\w+))*@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+");
    }

    public boolean isValidName(String name) {
        return name != null && name.length() <= 10;
    }

    public boolean isValidPasseord(String password) {
        return password != null && password.length() <= 12 && password.length() >= 6;
    }

    public boolean isValidUserAccount(String userAccount) {
        return userAccount != null && userAccount.length() <= 12;
    }

    //會員註冊
    //驗證使用者帳號格式是否符合
    //驗證使用者密碼格式是否符合
    //驗證使用者姓名格式是否符合
    //驗證email格式是否正確

    @PostMapping("register")
    public ResponseEntity<RegisterResponse> register(@RequestBody Account account) {

        if (!isValidEmail(account.getEmail()) || !isValidName(account.getName()) || !isValidPasseord(account.getPassword()) || !isValidUserAccount(account.getUserAccount())) {
            RegisterResponse response = new RegisterResponse(-1, "Wrong Format");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        RegisterResult result = registerService.register(account);
        if (result.getCode() == 0) {
            RegisterResponse response = new RegisterResponse(1, "Register Successful");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if (result.getCode() == -11) {
            RegisterResponse response = new RegisterResponse(-2, "UserAccount Duplicate");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else if (result.getCode() == -12) {
            RegisterResponse response = new RegisterResponse(-3, "Email Duplicate");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
            RegisterResponse response = new RegisterResponse(-1, "Register Failed");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}



