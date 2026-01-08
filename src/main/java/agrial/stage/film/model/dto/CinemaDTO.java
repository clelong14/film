package agrial.stage.film.model.dto;

import lombok.Data;

@Data
public class CinemaDTO {
    private Integer id;
    private String nom;
    private String ville;
    private Integer cpostal;
    private String adresse;
    private Integer telephone;
    private String email;
}
