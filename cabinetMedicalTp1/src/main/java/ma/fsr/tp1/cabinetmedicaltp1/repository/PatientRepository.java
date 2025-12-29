package ma.fsr.tp1.cabinetmedicaltp1.repository;

import ma.fsr.tp1.cabinetmedicaltp1.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
