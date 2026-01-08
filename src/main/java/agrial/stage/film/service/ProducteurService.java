package agrial.stage.film.service;

import agrial.stage.film.model.Producteur;
import agrial.stage.film.model.dto.FilmDTO;
import agrial.stage.film.model.dto.ProducteurDTO;
import agrial.stage.film.model.mapper.FilmMapper;
import agrial.stage.film.model.mapper.ProducteurMapper;
import agrial.stage.film.repository.ProducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducteurService {

    @Autowired
    private ProducteurRepository producteurRepository;

    public Optional<ProducteurDTO> getProducteurDTO(Integer id) {
        return producteurRepository.findById(id)
                .map(ProducteurMapper::toDTO);
    }

    public Producteur saveProducteur(Producteur producteur) {
        return producteurRepository.save(producteur);
    }

    public List<Producteur> findByNom(String nom) {
        return producteurRepository.findByNomSansEspace(nom);
    }

    public List<Producteur> getProducteursParFilm(Integer id) {
        return producteurRepository.findByFilms_Id(id);
    }
}