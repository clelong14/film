package agrial.stage.film.model.mapper;

import agrial.stage.film.model.Directeur;
import agrial.stage.film.model.dto.DirecteurDTO;
import java.time.LocalDate;

public class DirecteurMapper {

    public static DirecteurDTO toDTO(Directeur d) {
        if (d == null) return null;

        DirecteurDTO dto = new DirecteurDTO();
        dto.setId(d.getId());
        dto.setNom(d.getNom());
        dto.setPrenom(d.getPrenom());
        if (d.getDateNaissance() != null) {
            dto.setDateNaissance(LocalDate.parse(d.getDateNaissance()));
        }

        return dto;
    }

    public static Directeur toEntity(DirecteurDTO dto) {
        if (dto == null) return null;

        Directeur d = new Directeur();
        d.setId(dto.getId());
        d.setPrenom(dto.getPrenom());
        d.setNom(dto.getNom());

        if (dto.getDateNaissance() != null) {
            d.setDateNaissance(dto.getDateNaissance().toString());
        }

        return d;
    }
}