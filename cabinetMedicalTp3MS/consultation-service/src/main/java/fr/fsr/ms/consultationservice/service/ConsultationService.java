package fr.fsr.ms.consultationservice.service;

import fr.fsr.ms.consultationservice.client.RendezVousClient;
import fr.fsr.ms.consultationservice.dto.ConsultationDto;
import fr.fsr.ms.consultationservice.model.Consultation;
import fr.fsr.ms.consultationservice.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultationService {
    private final RendezVousClient rendezVousClient;
    private final ConsultationRepository consultationRepository;
    private  ConsultationDto consultationDto ;

    public ConsultationService(ConsultationRepository consultationRepository, RendezVousClient rendezVousClient) {
        this.consultationRepository = consultationRepository;
        this.rendezVousClient = rendezVousClient;
    }

    public Consultation create(ConsultationDto consultationDto){

        if (consultationDto.getDateConsultation()==null)
            throw new RuntimeException("La date de consultation est obligatoire.");
        if (consultationDto.getDateConsultation().isBefore(LocalDate.now()))
            throw new RuntimeException("Date de consultation invalide.");
        if (consultationDto.getRapport().length()<10)
            throw new RuntimeException("Rapport de consultation insuffisant.");
        rendezVousClient.checkRendezVousIfExist(consultationDto.getRendezVousId());

        Consultation consultation = new Consultation();
        consultation.setDateConsultation(consultationDto.getDateConsultation());
        consultation.setRendezVousId(consultationDto.getRendezVousId());
        consultation.setRapport(consultationDto.getRapport());
        return consultationRepository.save(consultation);
    }
    public List<Consultation>  getAll(){
        return consultationRepository.findAll();
    }

    public Consultation getById(Long id) {
        return consultationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Consultation introuvable avec l'id : " + id)
                );
    }

    public Consultation update(Long id, ConsultationDto consultationDto) {

        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation introuvable avec l'id : " + id));

        if (consultationDto.getDateConsultation() != null) {
            consultation.setDateConsultation(consultationDto.getDateConsultation());
        }

        if (consultationDto.getRapport() != null) {
            consultation.setRapport(consultationDto.getRapport());
        }

        if (consultationDto.getRendezVousId() != null) {
            consultation.setRendezVousId(consultationDto.getRendezVousId());
        }

        return consultationRepository.save(consultation);
    }


    public void delete(Long id) {
        consultationRepository.deleteById(id);
    }

}
