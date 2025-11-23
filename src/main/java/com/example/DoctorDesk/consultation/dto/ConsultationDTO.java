package com.example.DoctorDesk.consultation.dto;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultationDTO {

    private Long id;
    private Long appointmentId;
    private LocalDateTime consultaionDate;
    private String subjectiveNotes;
    private String objectiveFindings;
    private String assessment;
    private String plan;
}
