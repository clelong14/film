package agrial.stage.film.controller;

import agrial.stage.film.model.Cinema;
import agrial.stage.film.service.CinemaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cinemas")
@CrossOrigin(origins = "*")
@Tag(name = "Cinemas", description = "Gestion des cinemas")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @Operation(summary = "Liste de tous les films")
    public List<Cinema> findAll() {
        return cinemaService.getAllCinemas();
    }
}
