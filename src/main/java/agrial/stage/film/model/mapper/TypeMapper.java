package agrial.stage.film.model.mapper;

import agrial.stage.film.model.Type;
import agrial.stage.film.model.dto.TypeDTO;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class TypeMapper {
    public static TypeDTO toDTO(Type t) {
        if (t == null) return null;

        TypeDTO dto = new TypeDTO();
        dto.setId(t.getId());
        dto.setLibelle(t.getLibelle());

        return dto;
    }

    public static Type toEntity(TypeDTO dto) {
        if (dto == null) return null;

        Type t = new Type();
        t.setId(dto.getId());
        t.setLibelle(dto.getLibelle());

        return t;
    }
}
