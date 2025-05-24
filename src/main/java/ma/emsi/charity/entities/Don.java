package ma.emsi.charity.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Don {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "don_id")
    private Long id;

    @Column(nullable = false)
    private double montant;

    @Column(name = "date_don", nullable = false)
    private LocalDateTime dateDon;

    @Column(name = "methode_paiement", nullable = false)
    private String methodePaiement;

    @Column(name = "transaction_id", unique = true)
    private String transactionId;
}
