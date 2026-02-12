package fr.fsr.ms.consultationservice.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDto {
     LocalDate dateConsultation ;
    String rapport ;
    Long rendezVousId ;
}
