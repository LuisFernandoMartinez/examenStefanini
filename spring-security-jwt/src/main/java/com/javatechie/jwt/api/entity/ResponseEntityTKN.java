package com.javatechie.jwt.api.entity;


public class ResponseEntityTKN {

    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ResponseEntityTKN(String token) {
        this.token = token;
    }
}
