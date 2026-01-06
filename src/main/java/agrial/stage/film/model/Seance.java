package agrial.stage.film.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateHeure;
    private String salle;
    private Double prix;
    private Integer placesDisponibles;
    private String description;

    @ManyToOne
    @JoinColumn(name = "film_id")
    @JsonBackReference
    private Film film;
}