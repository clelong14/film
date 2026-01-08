package agrial.stage.film.controller;

import agrial.stage.film.model.Seance;
import agrial.stage.film.model.dto.DirecteurDTO;
import agrial.stage.film.model.dto.SeanceDTO;
import agrial.stage.film.service.SeanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seances")
@Tag(name = "Séances", description = "Gestion des horaires et des salles")
public class SeanceController {

    @Autowired
    private SeanceService seanceService;

    @GetMapping("/{seanceId}")
    @Operation(summary = "Récupérer une séance par son ID")
    public Optional<SeanceDTO> getSeanceDTO(@PathVariable int seanceId) {
        return seanceService.getSeanceDTO(seanceId);
    }

    @PostMapping("/")
    @Operation(summary = "Créer une séance")
    public Seance createSeance(@RequestBody Seance seance) {
        return seanceService.saveSeance(seance);
    }

    @GetMapping("/all")
    @Operation(summary = "Récupérer toutes les séances")
    public List<Seance> getAllSeances() {
        return seanceService.getAllSeances();
    }

    @GetMapping("/film/{filmId}")
    @Operation(summary = "Récupérer les séances d'un film par son ID")
    public List<Seance> getByFilm(@PathVariable Integer filmId) {
        return seanceService.getSeancesParFilm(filmId);
    }

    @GetMapping("/type/{libelle}")
    @Operation(summary = "Récupérer les séances par genre de film")
    public List<Seance> getByType(@PathVariable String libelle) {
        return seanceService.getSeancesParType(libelle);
    }
}