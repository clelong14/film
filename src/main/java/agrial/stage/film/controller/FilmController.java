package agrial.stage.film.controller;

import agrial.stage.film.model.Film;
import agrial.stage.film.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
@Tag(name = "Films", description = "Gestion des films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping("/")
    @Operation(summary = "Création de film")
    public Film createFilm(@RequestBody Film film) {
        return filmService.saveFilm(film);
    }

    @GetMapping("/nom/{nom}")
    @Operation(summary = "Recherche de nom de film par nom de directeur")
    public List<Film> findByNom(@PathVariable String nom) {
        return filmService.findByNom(nom);
    }

    @GetMapping("/directeur/{directeurId}")
    @Operation(summary = "Recherche de directeur par ID")
    public List<Film> getFilmsParDirecteur(@PathVariable Integer directeurId) {
        return filmService.getFilmsParDirecteur(directeurId);
    }
}
