package agrial.stage.film.controller;

import agrial.stage.film.model.Producteur;
import agrial.stage.film.model.dto.FilmDTO;
import agrial.stage.film.model.dto.ProducteurDTO;
import agrial.stage.film.service.ProducteurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producteurs")
@Tag(name = "Producteurs", description = "Gestion des producteurs")
public class ProducteurController {

    @Autowired
    private ProducteurService producteurService;

    @GetMapping("/{producteurId}")
    @Operation(summary = "Récupérer un film DTO par son ID")
    public Optional<ProducteurDTO> getProducteurDTO(@PathVariable int producteurId) {
        return producteurService.getProducteurDTO(producteurId);
    }

    @PostMapping("/")
    @Operation(summary = "Création d'un producteur")
    public Producteur createProducteur(@RequestBody Producteur producteur) {
        return producteurService.saveProducteur(producteur);
    }

    @GetMapping("/film/{nom}")
    @Operation(summary = "Trouver les producteurs d'un film")
    public List<Producteur> findByNom(@PathVariable String nom) {
        return producteurService.findByNom(nom);
    }

    @GetMapping("/film/{filmId}")
    @Operation(summary = "Trouver les producteurs d'un film")
    public List<Producteur> getProducteursParFilm(@PathVariable Integer filmId) {
        return producteurService.getProducteursParFilm(filmId);
    }
}