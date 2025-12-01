package com.example.DoctorDesk.patient.services;

import java.util.List;

import com.example.DoctorDesk.enums.BloodGroup;
import com.example.DoctorDesk.enums.Genotype;
import com.example.DoctorDesk.patient.dto.PatientDTO;
import com.example.DoctorDesk.res.Response;

public interface PatientService {


    Response<PatientDTO> getPatientProfile();

    Response<?> updatePatientProfile(PatientDTO patientDTO);

    Response<PatientDTO> getPatientById(Long patientId);

    Response<List<BloodGroup>> getAllBloodGroupEnums();
    Response<List<Genotype>>getAllGenotypeEnums();

}