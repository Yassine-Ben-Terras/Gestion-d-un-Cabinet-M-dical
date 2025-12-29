package ma.fsr.tp1.cabinetmedicaltp1;

import ma.fsr.tp1.cabinetmedicaltp1.repository.MedecinRepository;
import ma.fsr.tp1.cabinetmedicaltp1.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabinetMedicalTp1Application {
    @Autowired
    RendezVousRepository rendezVousRepository;

    @Autowired
    MedecinRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(CabinetMedicalTp1Application.class, args);
    }

}
