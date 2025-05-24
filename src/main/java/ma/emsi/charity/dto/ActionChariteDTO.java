package ma.emsi.charity.dto;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date; // ✅ L'import manquant

@Data
public class ActionChariteDTO {
    private Long id;
    private String titre;
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String lieu;
    private Double objectifCollecte;
    private Double montantActuel;
    private String mediaUrl;
    private Long organizationId;
    private boolean estArchivee;
}
