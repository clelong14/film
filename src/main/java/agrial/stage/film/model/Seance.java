package agrial.stage.film.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Integer placesDisponibles;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinema_id")
    @JsonIgnoreProperties("seances")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "film_id")
    @JsonBackReference
    private Film film;
}