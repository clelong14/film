package agrial.stage.film.service;

import agrial.stage.film.model.Cinema;
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

    // Récupérer par ID
    public Cinema getCinemaById(Integer id) {
        return cinemaRepository.findById(id).orElse(null);
    }

    // Créer ou Modifier
    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    // Supprimer
    public void deleteCinema(Integer id) {
        cinemaRepository.deleteById(id);
    }
}