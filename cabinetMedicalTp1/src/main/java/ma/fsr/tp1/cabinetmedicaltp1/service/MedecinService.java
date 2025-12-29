package ma.fsr.tp1.cabinetmedicaltp1.service;

import ma.fsr.tp1.cabinetmedicaltp1.model.Medecin;
import ma.fsr.tp1.cabinetmedicaltp1.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {

    @Autowired
    MedecinRepository medecinRepository;

    public Medecin create(Medecin medecin) throws Exception {
        if(medecin.getSpecialite() == null) {
            throw new Exception("La specialitée est obligatoire");
        }
        return medecinRepository.save(medecin);
    }



    public Medecin update(Medecin medecin) throws Exception {
        Optional<Medecin> m = medecinRepository.findById(medecin.getId());
        if(!m.isPresent()){
            throw new Exception("Medecin introvable");
        }
        return medecinRepository.save(medecin);
    }

    public List<Medecin> list() {
        return medecinRepository.findAll();
    }

    public void delete(Long idMedecin){
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
        if (medecin != null) {
            medecinRepository.delete(medecin);
        }
    }
}
