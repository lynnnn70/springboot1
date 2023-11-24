package com.example.demo.dto;

public class CommonResponse {

    private String messsage;

    public String getMesssage() {
        return messsage;
    }
    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public CommonResponse(){

    }

    public CommonResponse(String messsage) {
        this.messsage = messsage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("{messsage:'").append(messsage).append('\'');
        sb.append("}");
        return sb.toString();
    }

}
