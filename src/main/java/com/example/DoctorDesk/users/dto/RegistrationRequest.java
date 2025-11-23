package com.example.DoctorDesk.users.dto;



import java.util.List;

import com.example.DoctorDesk.enums.Specialization;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationRequest {

    @NotBlank(message="Name is Required")
    private String name;

    private Specialization specialization;

    private String LicenseNumber;

    @NotBlank(message="Email is Required")
    @Email
    private String email;

    private List<String> roles;

    @NotBlank(message="Password is Required")
    private String password;




}
