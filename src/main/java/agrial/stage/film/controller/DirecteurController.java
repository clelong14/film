package agrial.stage.film.controller;

import agrial.stage.film.model.Directeur;
import agrial.stage.film.model.dto.DirecteurDTO;
import agrial.stage.film.model.mapper.DirecteurMapper;
import agrial.stage.film.repository.DirecteurRepository;
import agrial.stage.film.service.DirecteurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directeurs")
@Tag(name = "Directeurs", description = "Gestion des directeurs")
public class DirecteurController {

    @Autowired
    private DirecteurService directeurService;

    @Autowired
    private DirecteurRepository directeurRepository;

    /*@GetMapping("/{directeurId}")
    @Operation(summary = "Récupération d'un directeur par ID")
    public Optional<DirecteurDTO> getDirecteurDTO(@PathVariable int directeurId) {
        return directeurService.getDirecteurDTO(directeurId);
    }*/

    @GetMapping("/{directeurId}")
    @Operation(summary = "Récupération d'un directeur par ID")
    public ResponseEntity<DirecteurDTO> getDirecteurById(@PathVariable int directeurId) {
        return directeurService.getDirecteurDTO(directeurId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<DirecteurDTO> getAllDirecteur() {
        // Correction ici : on ajoute le 's' et 'DTO' pour correspondre au service
        return directeurService.getAllDirecteursDTO();
    }


    @PostMapping("/create")
    @Operation(summary = "Création de directeur")
    public Directeur createDirecteur(@RequestBody Directeur directeur) {
        return directeurService.saveDirecteur(directeur);
    }

    @GetMapping("/nom/{nom}")
    @Operation(summary = "Recherche de nom de directeur par nom de film")
    public List<Directeur> findByNom(@PathVariable String nom) {
        return directeurService.findByNom(nom);
    }

    @GetMapping("/film/{filmId}")
    @Operation(summary = "Recherche de directeur par ID")
    public List<Directeur> getDirecteursParFilm(@PathVariable Integer filmId) {
        return directeurService.getDirecteursParFilm(filmId);
    }
}
