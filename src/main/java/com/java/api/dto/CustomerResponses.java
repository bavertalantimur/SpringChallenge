package com.java.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter


public class CustomerResponses {
    private int statusCode;
    private String status;
    private String message;
    private List<CustomerDto> list;

    public CustomerResponses(int statusCode, String status, String message) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }


    public CustomerResponses(int statusCode, String status, String message, List<CustomerDto> list) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
        this.list = list;
    }



}
