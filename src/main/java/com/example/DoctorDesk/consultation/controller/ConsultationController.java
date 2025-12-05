package com.example.DoctorDesk.consultation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DoctorDesk.consultation.dto.ConsultationDTO;
import com.example.DoctorDesk.consultation.services.ConsultationService;
import com.example.DoctorDesk.res.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/consultations")
public class ConsultationController {


    private final ConsultationService consultationService;

    @PostMapping
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<Response<ConsultationDTO>> createConsultation(
            @RequestBody ConsultationDTO consultationDTO) {
        return ResponseEntity.ok(consultationService.createConsultation(consultationDTO));
    }

    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<Response<ConsultationDTO>> getConsultationByAppointmentId(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(consultationService.getConsultationByAppointmentId(appointmentId));
    }

    @GetMapping("/history")
    public ResponseEntity<Response<List<ConsultationDTO>>> getConsultationHistoryForPatient(
            @RequestParam(required = false) Long patientId) {
        return ResponseEntity.ok(consultationService.getConsultationHistoryForPatient(patientId));
    }

}
