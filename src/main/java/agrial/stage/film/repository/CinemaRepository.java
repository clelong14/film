package agrial.stage.film.repository;

import agrial.stage.film.model.Cinema;
import agrial.stage.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    List<Cinema> findAll();
}
