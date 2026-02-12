package fr.fsr.ms.consultationservice.repository;

import fr.fsr.ms.consultationservice.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {}