package com.example.DoctorDesk.doctor.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.DoctorDesk.doctor.dto.DoctorDTO;
import com.example.DoctorDesk.doctor.entity.Doctor;
import com.example.DoctorDesk.doctor.repo.DoctorRepo;
import com.example.DoctorDesk.enums.Specialization;
import com.example.DoctorDesk.exceptions.NotFoundException;
import com.example.DoctorDesk.res.Response;
import com.example.DoctorDesk.users.Entity.User;
import com.example.DoctorDesk.users.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorServiceImpl implements DoctorService{


    private final DoctorRepo doctorRepo;
    private final UserService userService;
    private final ModelMapper modelMapper;


    @Override
    public Response<DoctorDTO> getDoctorProfile() {

        User user = userService.getCurrentUser();

        Doctor doctor = doctorRepo.findByUser(user)
                .orElseThrow(() -> new NotFoundException("Doctor profile not found."));

        return Response.<DoctorDTO>builder()
                .statusCode(200)
                .message("Doctor profile retrieved successfully.")
                .data(modelMapper.map(doctor, DoctorDTO.class))
                .build();
    }

    @Override
    public Response<?> updateDoctorProfile(DoctorDTO doctorDTO) {

        User currentUser = userService.getCurrentUser();

        Doctor doctor = doctorRepo.findByUser(currentUser)
                .orElseThrow(() -> new NotFoundException("Doctor profile not found."));

        // Basic fields (firstName, lastName)
        if (StringUtils.hasText(doctorDTO.getFirstName())) {
            doctor.setFirstName(doctorDTO.getFirstName());
        }
        if (StringUtils.hasText(doctorDTO.getLastName())) {
            doctor.setLastName(doctorDTO.getLastName());
        }

         Optional.ofNullable(doctorDTO.getSpecialization()).ifPresent(doctor::setSpecialization);
        doctorRepo.save(doctor);
        log.info("Doctor profile updated ");

        return Response.builder()
                .statusCode(200)
                .message("Doctor profile updated successfully.")
                .build();

    }

    @Override
    public Response<List<DoctorDTO>> getAllDoctors() {

        List<Doctor> doctors = doctorRepo.findAll();

        List<DoctorDTO> doctorDTOS = doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .toList();

        return Response.<List<DoctorDTO>>builder()
                .statusCode(200)
                .message("All doctors retrieved successfully.")
                .data(doctorDTOS)
                .build();

    }

    @Override
    public Response<DoctorDTO> getDoctorById(Long doctorId) {

        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new NotFoundException("Doctor not found"));

        return Response.<DoctorDTO>builder()
                .statusCode(200)
                .message("Doctor retrieved successfully.")
                .data(modelMapper.map(doctor, DoctorDTO.class))
                .build();
    }

    @Override
    public Response<List<DoctorDTO>> searchDoctorsBySpecialization(Specialization specialization) {

        List<Doctor> doctors = doctorRepo.findBySpecialization(specialization);

        List<DoctorDTO> doctorDTOs = doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .toList();


        String message = doctors.isEmpty() ?
                "No doctors found for specialization: " + specialization.name() :
                "Doctors retrieved successfully for specialization: " + specialization.name();

        return Response.<List<DoctorDTO>>builder()
                .statusCode(200)
                .message(message)
                .data(doctorDTOs)
                .build();

    }

    @Override
    public Response<List<Specialization>> getAllSpecializationEnums() {

        List<Specialization> specializations = Arrays.asList(Specialization.values());

        return Response.<List<Specialization>>builder()
                .statusCode(200)
                .message("Specializations retrieved successfully")
                .data(specializations)
                .build();
    }
}
