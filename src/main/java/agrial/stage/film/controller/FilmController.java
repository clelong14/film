package agrial.stage.film.controller;

import agrial.stage.film.model.Film;
import agrial.stage.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping("/")
    public Film createFilm(@RequestBody Film film) {
        return filmService.saveFilm(film);
    }

    @GetMapping("/nom/{nom}")
    public List<Film> findByNom(@PathVariable String nom) {
        return filmService.findByNom(nom);
    }

    @GetMapping("/directeur/{directeurId}")
    public List<Film> getFilmsParDirecteur(@PathVariable Integer directeurId) {
        return filmService.getFilmsParDirecteur(directeurId);
    }
}
