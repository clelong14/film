package agrial.stage.film.controller;

import agrial.stage.film.model.Film;
import agrial.stage.film.model.dto.FilmDTO;
import agrial.stage.film.model.dto.TypeDTO;
import agrial.stage.film.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
@CrossOrigin(origins = "*")
@Tag(name = "Films", description = "Gestion des films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/{filmId}")
    public Optional<FilmDTO> getFilmDTO(@PathVariable int filmId) {
        return filmService.getFilmDTO(filmId);
    }

    @GetMapping("/")
    public List<FilmDTO> getAllFilms() {
        return filmService.getAllFilmDTO();
    }

    /*@GetMapping("/")
    @Operation(summary = "Liste de tous les films")
    public List<Film> findAll() {
        return filmService.getAllFilms();
    }*/

    /*@GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Integer id) {
        return filmService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/

    @PostMapping("/create")
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
