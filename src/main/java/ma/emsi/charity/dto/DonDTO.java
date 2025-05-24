package ma.emsi.charity.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DonDTO {
    private double montant;
    private LocalDateTime dateDon;
    private String methodePaiement;
}
