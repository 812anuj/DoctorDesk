package com.example.DoctorDesk.patient.entity;

import java.util.List;

import com.example.DoctorDesk.appointment.entity.Appointment;
import com.example.DoctorDesk.enums.BloodGroup;
import com.example.DoctorDesk.enums.Genotype;
import com.example.DoctorDesk.users.Entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String phone;
    
    @Lob
    private String knownAllergies;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    
    @Enumerated(EnumType.STRING)
    private Genotype genotype;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",unique = true)
    private User user;

    @OneToMany(mappedBy = "patient", cascade= CascadeType.ALL , orphanRemoval=true)
    private List<Appointment> appointments;

}
