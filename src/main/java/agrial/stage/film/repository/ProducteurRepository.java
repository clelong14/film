package agrial.stage.film.repository;

import agrial.stage.film.model.Producteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducteurRepository extends JpaRepository<Producteur, Integer> {
}