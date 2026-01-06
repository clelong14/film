package agrial.stage.film.repository;

import agrial.stage.film.model.Directeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DirecteurRepository extends JpaRepository<Directeur, Integer> {
    @Query("SELECT d FROM Directeur d JOIN d.films f " +
            "WHERE REPLACE(f.nom, ' ', '') ILIKE REPLACE(:nom, ' ', '')")
    List<Directeur> findByNomSansEspace(@Param("nom") String nom);

    List<Directeur> findByFilms_Id(Integer id);
}