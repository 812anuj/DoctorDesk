package com.example.DoctorDesk.appointment.services;

import java.util.List;

import com.example.DoctorDesk.appointment.dto.AppointmentDTO;
import com.example.DoctorDesk.res.Response;

public interface AppointmentService {

    Response<AppointmentDTO> bookAppointment(AppointmentDTO appointmentDTO);

    Response<List<AppointmentDTO>> getMyAppointments();

    Response<AppointmentDTO> cancelAppointment(Long appointmentId);

    Response<?> completeAppointment(Long appointmentId);

}
