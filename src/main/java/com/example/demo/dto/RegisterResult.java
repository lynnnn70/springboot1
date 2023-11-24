package com.example.demo.dto;

public class RegisterResult {

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RegisterResult(){
    }

    public RegisterResult(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("{code:").append(code);
        sb.append("}");
        return sb.toString();
    }


}
