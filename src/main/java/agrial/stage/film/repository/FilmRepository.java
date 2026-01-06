package agrial.stage.film.repository;

import org.springframework.stereotype.Repository;
import agrial.stage.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findByDirecteur_Nom(String nom);

    List<Film> findByDirecteur_Id(Integer id);

}