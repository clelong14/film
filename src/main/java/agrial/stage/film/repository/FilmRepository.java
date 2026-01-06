package agrial.stage.film.repository;

import org.springframework.stereotype.Repository;
import agrial.stage.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}