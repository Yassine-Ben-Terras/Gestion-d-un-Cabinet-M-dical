package ma.fsr.tp1.cabinetmedicaltp1.web;

import ma.fsr.tp1.cabinetmedicaltp1.model.Medecin;
import ma.fsr.tp1.cabinetmedicaltp1.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medecins")
public class MedecinController {
    @Autowired
    MedecinService medecinService;

    @PostMapping
    public Medecin create(@RequestBody Medecin medecin) throws Exception {
        return medecinService.create(medecin);
    }

    @GetMapping
    public List<Medecin> list() {
        return medecinService.list();
    }

    @DeleteMapping("/{idMedecin}")
    public void delete(@PathVariable Long idMedecin){
        medecinService.delete(idMedecin);
    }

}
