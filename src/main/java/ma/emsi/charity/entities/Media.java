package ma.emsi.charity.entities;

import jakarta.persistence.*;
        import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "medias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id")
    private Long id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String type; // "IMAGE", "VIDEO"
}