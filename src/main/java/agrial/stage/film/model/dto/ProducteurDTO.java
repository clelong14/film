package agrial.stage.film.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class ProducteurDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
}
