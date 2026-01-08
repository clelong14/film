package agrial.stage.film.repository;

import agrial.stage.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query("SELECT DISTINCT f FROM Film f " +
            "LEFT JOIN FETCH f.directeur d " +
            "LEFT JOIN FETCH f.producteur p " +
            "LEFT JOIN FETCH f.type t")
    List<Film> findAllWithDetails();

    List<Film> findByType_Libelle(String libelle);

    List<Film> findByDirecteur_Id(Integer id);

    List<Film> findByNom(String nom);
}