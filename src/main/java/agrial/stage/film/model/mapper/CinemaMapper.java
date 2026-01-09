package agrial.stage.film.model.mapper;

import agrial.stage.film.model.Cinema;
import agrial.stage.film.model.dto.CinemaDTO;

public class CinemaMapper {
    public static CinemaDTO toDTO(Cinema c) {
        if (c == null) return null;

        CinemaDTO dto = new CinemaDTO();
        dto.setId(c.getId());
        dto.setNom(c.getNom());
        dto.setVille(c.getVille());
        dto.setCpostal(c.getCpostal());
        dto.setAdresse(c.getAdresse());
        dto.setTelephone(c.getTelephone());
        dto.setEmail(c.getEmail());

        return dto;
    }


    public static Cinema toEntity(CinemaDTO dto) {
        if (dto == null) return null;


        Cinema c = new Cinema();
        c.setId(dto.getId());
        c.setNom(dto.getNom());
        c.setVille(dto.getVille());
        c.setCpostal(dto.getCpostal());
        c.setAdresse(dto.getAdresse());
        c.setTelephone(dto.getTelephone());
        c.setEmail(dto.getEmail());

        return c;
    }
}
