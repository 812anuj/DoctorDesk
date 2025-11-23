package com.example.DoctorDesk.appointment.entity;

import java.time.LocalDateTime;

import com.example.DoctorDesk.consultation.entity.Consultation;
import com.example.DoctorDesk.doctor.entity.Doctor;
import com.example.DoctorDesk.enums.AppointmentStatus;
import com.example.DoctorDesk.patient.entity.Patient;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime startTime; 
    private LocalDateTime endTime;
    private String meatingLink;

    private String purposeOfConsultation;
    
    private String initialSymptoms;
    
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "doctor_id",nullable=false)
    private Doctor doctor;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable=false)
    private Patient patient;

    @OneToOne(mappedBy="appointment",cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    private Consultation consultations;
    
}
