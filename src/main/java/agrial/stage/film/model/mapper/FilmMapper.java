package agrial.stage.film.model.mapper;

import agrial.stage.film.model.Film;
import agrial.stage.film.model.dto.FilmDTO;

import java.util.stream.Collectors;

public class FilmMapper {

    public static FilmDTO toDTO(Film f) {
        if (f == null) return null;

        FilmDTO dto = new FilmDTO();
        dto.setId(f.getId());
        dto.setNom(f.getNom());
        dto.setDateCreation(f.getDateCreation());
        dto.setDateSortie(f.getDateSortie());
        dto.setDuree(f.getDuree());
        dto.setImagePath(f.getImagePath());
        dto.setSynopsis(f.getSynopsis());


        if (f.getDirecteur() != null) {
            dto.setDirecteur(DirecteurMapper.toDTO(f.getDirecteur()));
        }

        if (f.getProducteur() != null) {
            dto.setProducteur(ProducteurMapper.toDTO(f.getProducteur()));
        }

        if (f.getType() != null) {
            dto.setType(TypeMapper.toDTO(f.getType()));
        }

        if (f.getSeances() != null) {
            dto.setSeances(
                    f.getSeances().stream()
                            .map(SeanceMapper::toDTO)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }


    public static Film toEntity(FilmDTO dto) {
        if (dto == null) return null;


        Film f = new Film();
        f.setId(dto.getId());
        f.setNom(dto.getNom());
        f.setDateCreation(dto.getDateCreation());
        f.setDateSortie(dto.getDateSortie());
        f.setDuree(dto.getDuree());
        f.setImagePath(dto.getImagePath());
        f.setSynopsis(dto.getSynopsis());

        return f;
    }
}
