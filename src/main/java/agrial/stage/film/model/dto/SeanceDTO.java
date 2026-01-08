package agrial.stage.film.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class SeanceDTO {
    private Integer id;
    private LocalDateTime dateHeure;
    private String salle;
    private Integer placesDisponibles;
    private String description;
    private DirecteurDTO directeur;
    private Integer filmId;
}
