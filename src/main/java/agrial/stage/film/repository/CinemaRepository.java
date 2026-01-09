package agrial.stage.film.repository;

import agrial.stage.film.model.Cinema;
import agrial.stage.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    List<Cinema> findAll();

    @Query("SELECT c FROM Cinema c WHERE " +
            "CAST(c.cpostal AS string) LIKE CONCAT('%', :search, '%') " +
            "OR UPPER(c.ville) LIKE UPPER(CONCAT('%', :search, '%'))")
    List<Cinema> findByCityOrZip(@Param("search") String search);
}
