package com.example.DoctorDesk.appointment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DoctorDesk.appointment.dto.AppointmentDTO;
import com.example.DoctorDesk.appointment.services.AppointmentService;
import com.example.DoctorDesk.res.Response;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Response<AppointmentDTO>> bookAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentService.bookAppointment(appointmentDTO));
    }

    @GetMapping
    public ResponseEntity<Response<List<AppointmentDTO>>> getMyAppointments() {
        return ResponseEntity.ok(appointmentService.getMyAppointments());
    }

    @PutMapping("/cancel/{appointmentId}")
    public ResponseEntity<Response<AppointmentDTO>> cancelAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(appointmentId));
    }

    @PutMapping("/complete/{appointmentId}")
    @PreAuthorize(("hasAuthority('DOCTOR')"))
    public ResponseEntity<Response<?>> completeAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(appointmentService.completeAppointment(appointmentId));
    }

}
