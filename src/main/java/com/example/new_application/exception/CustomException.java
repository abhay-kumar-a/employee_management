package com.example.new_application.exception;

public class CustomException extends Exception{

    String msg ;
    public CustomException(String msg) {
        this.msg=msg;
    }
    public CustomException() {

    }
    public String getMsg(){
        return this.msg;
    }
}
