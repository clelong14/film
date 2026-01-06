package agrial.stage.film.repository;

import agrial.stage.film.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

    @Query("SELECT t FROM Type t WHERE REPLACE(t.libelle, ' ', '') ILIKE REPLACE(:libelle, ' ', '')")
    List<Type> findByLibelleSansEspace(@Param("libelle") String libelle);

    List<Type> findByFilms_Id(Integer id);
}