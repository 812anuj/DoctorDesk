package com.example.DoctorDesk.doctor.services;

import java.util.List;

import com.example.DoctorDesk.doctor.dto.DoctorDTO;
import com.example.DoctorDesk.enums.Specialization;
import com.example.DoctorDesk.res.Response;

public interface DoctorService {


    Response<DoctorDTO> getDoctorProfile();
    Response<?>updateDoctorProfile(DoctorDTO doctorDTO);
    Response<List<DoctorDTO>> getAllDoctors();
    Response<DoctorDTO> getDoctorById(Long doctorId);

    Response<List<DoctorDTO>> searchDoctorsBySpecialization(Specialization specialization);
    Response<List<Specialization>> getAllSpecializationEnums();

}
