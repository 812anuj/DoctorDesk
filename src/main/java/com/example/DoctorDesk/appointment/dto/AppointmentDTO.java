package com.example.DoctorDesk.appointment.dto;

import java.time.LocalDateTime;

import com.example.DoctorDesk.doctor.dto.DoctorDTO;
import com.example.DoctorDesk.enums.AppointmentStatus;
import com.example.DoctorDesk.patient.dto.PatientDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
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
public class AppointmentDTO {
    
    private Long id;
    
    private String purposeOfConsultation;
    
    private String initialSymptoms;

    @NotNull(message = "Start time is required")
    @Future(message = "Appointment must be scheduled for the future date and time.")
    private LocalDateTime startTime;
    
    private LocalDateTime endTime;
    
    private String meatingLink;
    
    
    private AppointmentStatus status;
    
    private DoctorDTO doctor;
    
    private PatientDTO patient;
    
    
}
