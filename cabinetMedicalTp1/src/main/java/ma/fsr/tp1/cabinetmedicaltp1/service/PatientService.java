package ma.fsr.tp1.cabinetmedicaltp1.service;

import ma.fsr.tp1.cabinetmedicaltp1.model.Patient;
import ma.fsr.tp1.cabinetmedicaltp1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public Patient create(Patient patient) throws Exception {
        if(patient.getTelephone() == null) {
            throw new Exception("Le telephone est obligatoire");
        }
        return patientRepository.save(patient);
    }

    public List<Patient> list() {
        return patientRepository.findAll();
    }

    public void delete(Long idPatient){
        Patient patient = patientRepository.findById(idPatient).orElse(null);
        if (patient != null) {
            patientRepository.delete(patient);
        }
    }
}
