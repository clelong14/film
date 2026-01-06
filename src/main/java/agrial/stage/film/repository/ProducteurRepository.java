package agrial.stage.film.repository;

import agrial.stage.film.model.Producteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducteurRepository extends JpaRepository<Producteur, Integer> {

    @Query("SELECT p FROM Producteur p " +
            "JOIN p.directeur d " +
            "JOIN d.films f " +
            "WHERE REPLACE(f.nom, ' ', '') ILIKE REPLACE(:nom, ' ', '')")
    List<Producteur> findByNomSansEspace(@Param("nom") String nom);

    List<Producteur> findByDirecteur_Id(Integer id);
}