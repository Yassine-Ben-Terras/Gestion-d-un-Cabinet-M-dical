package fr.fsr.ms.consultationservice.web;

import fr.fsr.ms.consultationservice.dto.ConsultationDto;
import fr.fsr.ms.consultationservice.model.Consultation;
import fr.fsr.ms.consultationservice.service.ConsultationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/api/v1/consultations")
public class ConsultationController {

    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {

        this.consultationService = consultationService;
    }

        @GetMapping
        public List<Consultation> getAll() {
            return consultationService.getAll();
        }

        @GetMapping ("/{id}")
        public Consultation getById(@PathVariable long id) {
            return consultationService.getById(id);
        }

        @PostMapping
        public Consultation create(@RequestBody ConsultationDto consultationDto) {
            return consultationService.create(consultationDto);
        }

        @PatchMapping("/{id}")
        public Consultation update(@PathVariable Long id ,@RequestBody ConsultationDto consultationDto) {
            return consultationService.update(id,consultationDto);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            consultationService.delete(id);
        }
}
