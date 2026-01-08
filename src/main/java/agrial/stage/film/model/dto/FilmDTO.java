package agrial.stage.film.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
public class FilmDTO {
    private Integer id;
    private String nom;
    private LocalDate dateCreation;
    private LocalDate dateSortie;
    private String duree;
    private String imagePath;
    private String synopsis;
    private DirecteurDTO directeur;
    private ProducteurDTO producteur;
    private TypeDTO type;
    private List<SeanceDTO> seances;
}
