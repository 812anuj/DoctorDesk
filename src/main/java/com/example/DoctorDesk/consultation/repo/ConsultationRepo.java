package com.example.DoctorDesk.consultation.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DoctorDesk.consultation.entity.Consultation;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {
    Optional<Consultation> findByAppointmentId(Long appointmentId); // Fetch consultation by appointmentId
   
    List<Consultation> findByAppointmentPatientIdOrderByConsultationDateDesc(Long patientId);
}
