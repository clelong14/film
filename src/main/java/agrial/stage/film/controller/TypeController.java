package agrial.stage.film.controller;

import agrial.stage.film.model.Film;
import agrial.stage.film.model.Type;
import agrial.stage.film.service.TypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
@Tag(name = "Types", description = "Gestion des genres cinématographiques")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping("/")
    @Operation(summary = "Créer un nouveau genre")
    public Type createType(@RequestBody Type type) {
        return typeService.saveType(type);
    }

    @GetMapping("/libelle/{libelle}")
    @Operation(summary = "Rechercher un genre par son nom")
    public List<Type> findByLibelle(@PathVariable String libelle) {
        return typeService.findByLibelle(libelle);
    }

    @GetMapping("/film/{filmId}")
    @Operation(summary = "Trouver le genre d'un film par l'ID du film")
    public List<Type> getTypeParFilm(@PathVariable Integer filmId) {
        return typeService.getTypeParFilm(filmId);
    }
}
