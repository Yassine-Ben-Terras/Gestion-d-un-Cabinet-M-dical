package ma.fsr.tp1.cabinetmedicaltp1.service;

import ma.fsr.tp1.cabinetmedicaltp1.model.Medecin;
import ma.fsr.tp1.cabinetmedicaltp1.model.Patient;
import ma.fsr.tp1.cabinetmedicaltp1.model.RendezVous;
import ma.fsr.tp1.cabinetmedicaltp1.repository.MedecinRepository;
import ma.fsr.tp1.cabinetmedicaltp1.repository.PatientRepository;
import ma.fsr.tp1.cabinetmedicaltp1.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RendezVousService {

    @Autowired
    RendezVousRepository rendezVousRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    MedecinRepository medecinRepository;


    public RendezVous create(Long idPatient, Long idMedecin, LocalDate dateRDV) throws Exception {

        Patient patient = patientRepository.findById(idPatient).orElse(null);
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);

        if (patient == null) {
            throw new Exception("Le patient n'existe pas dans la base");
        }
        if (medecin == null) {
            throw new Exception("Le medecin n'existe pas dans la base");
        }

        RendezVous rendezVous = new RendezVous(null, dateRDV, "PLANIFIE", patient, medecin);

        return rendezVousRepository.save(rendezVous);
    }

    public List<RendezVous> list() {
        return rendezVousRepository.findAll();
    }
}
