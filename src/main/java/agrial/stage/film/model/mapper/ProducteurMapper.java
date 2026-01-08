package agrial.stage.film.model.mapper;

import agrial.stage.film.model.Producteur;
import agrial.stage.film.model.dto.ProducteurDTO;

import java.time.LocalDate;

public class ProducteurMapper {
    public static ProducteurDTO toDTO(Producteur p) {
        if (p == null) return null;

        ProducteurDTO dto = new ProducteurDTO();
        dto.setId(p.getId());
        dto.setNom(p.getNom());
        dto.setPrenom(p.getPrenom());
        if (p.getDateNaissance() != null) {
            dto.setDateNaissance(LocalDate.parse(p.getDateNaissance()));
        }

        return dto;
    }

    public static Producteur toEntity(ProducteurDTO dto) {
        if (dto == null) return null;

        Producteur p = new Producteur();
        p.setId(dto.getId());
        p.setPrenom(dto.getPrenom());
        p.setNom(dto.getNom());
        if (dto.getDateNaissance() != null) {
            p.setDateNaissance(dto.getDateNaissance().toString());
        }

        return p;
    }
}
