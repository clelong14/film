package agrial.stage.film.model.mapper;

import agrial.stage.film.model.Seance;
import agrial.stage.film.model.Seance;
import agrial.stage.film.model.dto.SeanceDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class SeanceMapper {
    public static SeanceDTO toDTO(Seance s) {
        if (s == null) return null;

        SeanceDTO dto = new SeanceDTO();
        dto.setId(s.getId());
        dto.setDateHeure(LocalDateTime.from(s.getDateHeure()));
        dto.setDescription(s.getDescription());
        dto.setPlacesDisponibles(s.getPlacesDisponibles());
        dto.setSalle(s.getSalle());

        if (s.getFilm() != null) {
            dto.setFilmId(s.getFilm().getId());
        }
        return dto;
    }

    public static Seance toEntity(SeanceDTO dto) {
        if (dto == null) return null;

        Seance s = new Seance();
        s.setId(dto.getId());
        s.setDescription(dto.getDescription());
        s.setPlacesDisponibles(dto.getPlacesDisponibles());
        s.setSalle(dto.getSalle());

        if (dto.getDateHeure() != null) {
            s.setDateHeure(LocalDateTime.from(dto.getDateHeure()));
        }

        return s;
    }
}
