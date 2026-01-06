package agrial.stage.film.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import agrial.stage.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Query("SELECT f FROM Film f WHERE REPLACE(f.directeur.nom, ' ', '') ILIKE REPLACE(:nom, ' ', '')")
    List<Film> findByDirecteurNomIgnoreSpaces(@Param("nom") String nom);

    List<Film> findByDirecteur_Id(Integer id);

}