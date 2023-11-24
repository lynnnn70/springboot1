package com.example.demo.dto;

public class LoginDTO {

    private String userAccount;

    private String password;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("{userAccount:'").append(userAccount).append('\'');
        sb.append(", password:'").append(password).append('\'');
        sb.append("}");
        return sb.toString();
    }

}
