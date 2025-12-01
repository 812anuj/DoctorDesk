package com.example.DoctorDesk.patient.dto;


import com.example.DoctorDesk.enums.BloodGroup;
import com.example.DoctorDesk.enums.Genotype;
import com.example.DoctorDesk.users.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
   
    private Long id;

    private String FirstName;
    private String LastName;
    private String dateOfBirth;
    private String phone;
    

    private String KnownAllergies;

  
    private BloodGroup bloodGroup;
    
  
    private Genotype genotype;


    private User user;
}
