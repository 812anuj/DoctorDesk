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

    @NotBlank(message = "Name is required")
    private String name;

    private Specialization specialization; //if users is a doctor specify his specialization

    private String licenseNumber; ////if users is a doctor licence number of the doctor

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    private List<String> roles;

    @NotBlank(message = "Password is required")
    private String password;
}
