package ma.fsr.soa.rendezvousserviceapi.service;

import ma.fsr.soa.cabinetrepo.model.Medecin;
import ma.fsr.soa.cabinetrepo.model.Patient;
import ma.fsr.soa.cabinetrepo.model.RendezVous;
import ma.fsr.soa.cabinetrepo.repository.MedecinRepository;
import ma.fsr.soa.cabinetrepo.repository.PatientRepository;
import ma.fsr.soa.cabinetrepo.repository.RendezVousRepository;
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

        if (dateRDV.isBefore(LocalDate.now())) {
            throw new Exception("La date du rendez-vous doit être future.");
        }

        Patient patient = patientRepository.findById(idPatient).orElse(null);
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);

        if (patient == null) {
            throw new Exception("Patient introuvable.");
        }
        if (medecin == null) {
            throw new Exception("Médecin introuvable");
        }

        RendezVous rendezVous = new RendezVous(null, dateRDV, "PLANIFIE", patient, medecin);

        return rendezVousRepository.save(rendezVous);
    }

    public List<RendezVous> list() {
        return rendezVousRepository.findAll();
    }
}
