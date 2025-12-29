package ma.fsr.tp1.cabinetmedicaltp1.web;


import ma.fsr.tp1.cabinetmedicaltp1.model.RendezVous;
import ma.fsr.tp1.cabinetmedicaltp1.service.RendezVousService;
import ma.fsr.tp1.cabinetmedicaltp1.web.dto.RdvRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {

    @Autowired
    RendezVousService rendezVousService;

    @PostMapping
    public RendezVous create(@RequestBody RdvRequest rdvRequest) throws Exception {
        return rendezVousService.create(rdvRequest.getIdPatient(), rdvRequest.getIdPatient(), rdvRequest.getDateRDV());
    }

    @GetMapping
    public List<RendezVous> listController() {
        return rendezVousService.list();
    }
}
