package com.example.DoctorDesk.consultation.services;

import java.util.List;

import com.example.DoctorDesk.consultation.dto.ConsultationDTO;
import com.example.DoctorDesk.res.Response;

public interface ConsultationService {

    Response<ConsultationDTO> createConsultation(ConsultationDTO consultationDTO);

    Response<ConsultationDTO> getConsultationByAppointmentId(Long appointmentId);

    Response<List<ConsultationDTO>> getConsultationHistoryForPatient(Long patientId);

}