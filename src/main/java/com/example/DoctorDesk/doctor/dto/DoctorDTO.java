package com.example.DoctorDesk.doctor.dto;

import com.example.DoctorDesk.users.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorDTO {

    private Long id;

    private String firstName;
    private String lastName;

    private String specialization;

    private String licenseNumber;

    private UserDTO user;
}
