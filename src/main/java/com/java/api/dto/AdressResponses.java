package com.java.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class AdressResponses {
    private int statusCode;
    private String status;
    private String message;
    private List<AdressDto> list;

    public AdressResponses(int statusCode, String status, String message, List<AdressDto> list) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
        this.list = list;
    }



    public AdressResponses(int statusCode, String status, String message) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }
}
