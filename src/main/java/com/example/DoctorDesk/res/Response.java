package com.example.DoctorDesk.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response <T>{
    private int statusCode;
    private String message;
    private T data;
    
}
