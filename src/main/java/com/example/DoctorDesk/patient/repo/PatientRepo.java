package com.example.DoctorDesk.patient.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DoctorDesk.patient.entity.Patient;
import com.example.DoctorDesk.users.Entity.User;

public interface PatientRepo extends JpaRepository<Patient, Long>{

    Optional<Patient> findByUser (User user);
}
