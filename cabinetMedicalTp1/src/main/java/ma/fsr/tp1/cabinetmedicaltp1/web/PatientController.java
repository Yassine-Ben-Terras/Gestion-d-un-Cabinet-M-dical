package ma.fsr.tp1.cabinetmedicaltp1.web;

import ma.fsr.tp1.cabinetmedicaltp1.model.Patient;
import ma.fsr.tp1.cabinetmedicaltp1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/api/v1/patients")
public class PatientController {

    @Autowired
    PatientService  patientService;

    @PostMapping
    public Patient create(@RequestBody Patient patient) throws Exception {
        return patientService.create(patient);
    }

    @GetMapping
    public List<Patient> patientList() {
        return patientService.list();
    }

    @DeleteMapping("/{idPatient}")
    public void delete(@PathVariable Long idPatient) {
        patientService.delete(idPatient);
    }

}
