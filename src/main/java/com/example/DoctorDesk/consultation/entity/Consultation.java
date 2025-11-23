package com.example.DoctorDesk.consultation.entity;

import java.time.LocalDateTime;

import com.example.DoctorDesk.appointment.entity.Appointment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private LocalDateTime consultaionDate;

    @Lob
    private String subjectiveNotes;

    @Lob
    private String objectiveFindings;

    @Lob
    private String assessment;

    @Lob
    private String plan;

    @OneToOne
    @JoinColumn(name = "appointment_id", unique = true ,nullable = false)
    private Appointment appointment;
    
}
