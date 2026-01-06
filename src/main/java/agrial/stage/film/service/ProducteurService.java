package agrial.stage.film.service;

import agrial.stage.film.model.Producteur;
import agrial.stage.film.repository.ProducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducteurService {

    @Autowired
    private ProducteurRepository producteurRepository; // minuscule ici

    public Producteur saveProducteur(Producteur producteur) {
        return producteurRepository.save(producteur);
    }

    public List<Producteur> findByNom(String nom) {
        return producteurRepository.findByNomSansEspace(nom);
    }

    public List<Producteur> getProducteursParDirecteur(Integer id) {
        return producteurRepository.findByDirecteur_Id(id);
    }
}