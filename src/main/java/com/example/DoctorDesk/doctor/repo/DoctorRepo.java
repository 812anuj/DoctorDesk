package com.example.DoctorDesk.doctor.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DoctorDesk.doctor.entity.Doctor;
import com.example.DoctorDesk.enums.Specialization;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUser(String user);
    List<Doctor> findBySpecialization(Specialization specialization);

}
