package agrial.stage.film.service;

import agrial.stage.film.model.Seance;
import agrial.stage.film.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService {

    @Autowired
    private SeanceRepository seanceRepository;

    public Seance saveSeance(Seance seance) {
        return seanceRepository.save(seance);
    }

    public List<Seance> getAllSeances() {
        return seanceRepository.findAll();
    }

    public List<Seance> getSeancesParFilm(Integer filmId) {
        return seanceRepository.findByFilm_Id(filmId);
    }

    public List<Seance> getSeancesParType(String libelle) {
        return seanceRepository.findByFilmType(libelle);
    }
}