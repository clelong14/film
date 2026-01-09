package agrial.stage.film.controller;

import agrial.stage.film.model.Cinema;
import agrial.stage.film.repository.CinemaRepository;
import agrial.stage.film.service.CinemaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
@CrossOrigin(origins = "*")
@Tag(name = "Cinemas", description = "Gestion des cinémas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private CinemaRepository cinemaRepository;

    @GetMapping("/")
    @Operation(summary = "Liste de tous les cinémas")
    public List<Cinema> findAll() {
        return cinemaService.getAllCinemas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un cinéma par son ID")
    public Cinema findById(@PathVariable Integer id) {
        return cinemaService.getCinemaById(id);
    }

    @PostMapping("/")
    @Operation(summary = "Ajouter un nouveau cinéma")
    public Cinema create(@RequestBody Cinema cinema) {
        return cinemaService.saveCinema(cinema);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un cinéma existant")
    public Cinema update(@PathVariable Integer id, @RequestBody Cinema cinema) {
        cinema.setId(id); // On s'assure que l'ID est le bon
        return cinemaService.saveCinema(cinema);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un cinéma")
    public void delete(@PathVariable Integer id) {
        cinemaService.deleteCinema(id);
    }

    @GetMapping("/search")
    public List<Cinema> search(@RequestParam(name = "cpostal") String cpostal) {
        return cinemaService.findByCityOrZip(Integer.valueOf(cpostal));
    }
}