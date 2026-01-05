package ma.fsr.soa.rendezvousserviceapi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RdvRequest {
    private Long idPatient;
    private Long idMedecin;
    private LocalDate dateRDV;
}
