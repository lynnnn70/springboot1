package com.example.demo.member.dto;

public class RegisterResponse {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RegisterResponse() {
    }

    public RegisterResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("{code:").append(code);
        sb.append(", message:'").append(message).append('\'');
        sb.append("}");
        return sb.toString();
    }
}
