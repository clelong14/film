package agrial.stage.film.service;

import agrial.stage.film.model.Type;
import agrial.stage.film.model.dto.ProducteurDTO;
import agrial.stage.film.model.dto.TypeDTO;
import agrial.stage.film.model.mapper.ProducteurMapper;
import agrial.stage.film.model.mapper.TypeMapper;
import agrial.stage.film.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public Optional<TypeDTO> getTypeDTO(Integer id) {
        return typeRepository.findById(id)
                .map(TypeMapper::toDTO);
    }

    public List<TypeDTO> getAllTypesDTO() {
        return typeRepository.findAll()
                .stream()
                .map(TypeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    public List<Type> findByLibelle(String libelle) {
        return typeRepository.findByLibelleSansEspace(libelle);
    }

    public List<Type> getTypeParFilm(Integer filmId) {
        return typeRepository.findByFilms_Id(filmId);
    }
}