package ma.fsr.soa.rendezvousserviceapi.web;

import ma.fsr.soa.cabinetrepo.model.RendezVous;
import ma.fsr.soa.rendezvousserviceapi.service.RendezVousService;
import ma.fsr.soa.rendezvousserviceapi.web.dto.RdvRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/api/v1/rendezvous")
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
