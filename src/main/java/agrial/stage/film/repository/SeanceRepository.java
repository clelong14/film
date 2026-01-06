package agrial.stage.film.repository;

import agrial.stage.film.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {

    List<Seance> findByFilm_Id(Integer filmId);

    @Query("SELECT s FROM Seance s JOIN s.film f JOIN f.type t WHERE t.libelle = :libelle")
    List<Seance> findByFilmType(@Param("libelle") String libelle);
}