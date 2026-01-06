package agrial.stage.film.service;

import agrial.stage.film.model.Type;
import agrial.stage.film.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

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