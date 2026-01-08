package agrial.stage.film.service;

import agrial.stage.film.model.Cinema;
import agrial.stage.film.model.Film;
import agrial.stage.film.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }
}
