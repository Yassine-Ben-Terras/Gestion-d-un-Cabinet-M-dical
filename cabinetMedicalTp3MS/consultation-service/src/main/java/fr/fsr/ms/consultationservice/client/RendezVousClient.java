package fr.fsr.ms.consultationservice.client;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RendezVousClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${api.gateway.url}")
    private String rendezVousServiceUrl ;

    public void checkRendezVousIfExist(Long rendezVousiId){
        try{
            restTemplate.getForObject(
                    rendezVousServiceUrl+ "/api/rendezvous/" + rendezVousiId,
                    Object.class
            );
        }catch (Exception e){
            throw new RuntimeException("RendezVous introuvable");
        }
    }

}
