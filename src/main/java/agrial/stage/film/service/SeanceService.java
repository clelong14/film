package agrial.stage.film.service;

import agrial.stage.film.model.Seance;
import agrial.stage.film.model.dto.SeanceDTO;
import agrial.stage.film.model.dto.TypeDTO;
import agrial.stage.film.model.mapper.SeanceMapper;
import agrial.stage.film.model.mapper.TypeMapper;
import agrial.stage.film.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceService {

    @Autowired
    private SeanceRepository seanceRepository;

    public Optional<SeanceDTO> getSeanceDTO(Integer id) {
        return seanceRepository.findById(id)
                .map(SeanceMapper::toDTO);
    }

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