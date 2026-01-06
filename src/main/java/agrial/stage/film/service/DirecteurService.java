package agrial.stage.film.service;

import agrial.stage.film.model.Directeur;
import agrial.stage.film.repository.DirecteurRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class DirecteurService {
    @Autowired
    private DirecteurRepository directeurRepository;


    public Directeur saveDirecteur(Directeur directeur) {
        Directeur savedDirecteur = directeurRepository.save(directeur);
        return savedDirecteur;
    }

    public List<Directeur> findByNom(String nom) {
        return directeurRepository.findByNomSansEspace(nom);
    }

    public List<Directeur> getDirecteursParFilm(Integer id) {
        return directeurRepository.findByFilms_Id(id);
    }
}
