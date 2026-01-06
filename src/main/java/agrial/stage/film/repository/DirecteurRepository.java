package agrial.stage.film.repository;

import agrial.stage.film.model.Directeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirecteurRepository extends JpaRepository<Directeur, Integer> {
}