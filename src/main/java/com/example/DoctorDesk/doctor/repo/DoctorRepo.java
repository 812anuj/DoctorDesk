package com.example.DoctorDesk.doctor.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DoctorDesk.doctor.entity.Doctor;
import com.example.DoctorDesk.enums.Specialization;
import com.example.DoctorDesk.users.Entity.User;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    
    Optional<Doctor> findByUser(User user);

    List<Doctor> findBySpecialization(Specialization specialization);

}
