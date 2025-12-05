package com.example.DoctorDesk.doctor.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DoctorDesk.doctor.dto.DoctorDTO;
import com.example.DoctorDesk.doctor.services.DoctorService;
import com.example.DoctorDesk.enums.Specialization;
import com.example.DoctorDesk.res.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;


    @GetMapping("/me")
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<Response<DoctorDTO>> getDoctorProfile() {
        return ResponseEntity.ok(doctorService.getDoctorProfile());
    }

    @PutMapping("/me")
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<Response<?>> updateDoctorProfile(@RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.ok(doctorService.updateDoctorProfile(doctorDTO));
    }
     @GetMapping
    public ResponseEntity<Response<List<DoctorDTO>>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Response<DoctorDTO>> getDoctorById(@PathVariable Long doctorId) {
        return ResponseEntity.ok(doctorService.getDoctorById(doctorId));
    }

    @GetMapping("/filter")
    public ResponseEntity<Response<List<DoctorDTO>>> searchDoctorsBySpecialization(
            @RequestParam(required = true) Specialization specialization
    ) {
        return ResponseEntity.ok(doctorService.searchDoctorsBySpecialization(specialization));
    }

    @GetMapping("/specializations")
    public ResponseEntity<Response<List<Specialization>>> getAllSpecializationEnums() {
        return ResponseEntity.ok(doctorService.getAllSpecializationEnums());
    }


}

