package agrial.stage.film.service;

import agrial.stage.film.model.Film;
import agrial.stage.film.repository.FilmRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;


    public Film saveFilm(Film film) {
        Film savedFilm = filmRepository.save(film);
        return savedFilm;
    }

    public List<Film> findByNom(String nom) {
        return filmRepository.findByDirecteur_Nom(nom);
    }

    public List<Film> getFilmsParDirecteur(Integer id) {
        return filmRepository.findByDirecteur_Id(id);
    }


}
