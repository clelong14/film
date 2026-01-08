package agrial.stage.film.service;

import agrial.stage.film.model.Film;
import agrial.stage.film.model.dto.FilmDTO;
import agrial.stage.film.model.mapper.FilmMapper;
import agrial.stage.film.model.mapper.TypeMapper;
import agrial.stage.film.repository.FilmRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Data
@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public List<FilmDTO> getAllFilmDTO() {
        return filmRepository.findAll()
                .stream()
                .map(FilmMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<FilmDTO> getFilmDTO(Integer id) {
        return filmRepository.findById(id)
                .map(FilmMapper::toDTO);
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> findById(Integer id) {
        return filmRepository.findById(id);
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public List<Film> getFilmsParDirecteur(Integer id) {
        return filmRepository.findByDirecteur_Id(id);
    }

    public List<Film> findByNom(String nom) {
        return filmRepository.findByNom(nom);
    }
}