package agrial.stage.film.repository;

import agrial.stage.film.model.Film;
import agrial.stage.film.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByEmail(String email);
}
