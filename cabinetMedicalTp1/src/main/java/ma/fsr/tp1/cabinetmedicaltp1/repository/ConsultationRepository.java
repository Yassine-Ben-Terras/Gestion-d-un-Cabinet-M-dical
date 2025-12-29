package ma.fsr.tp1.cabinetmedicaltp1.repository;

import ma.fsr.tp1.cabinetmedicaltp1.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
