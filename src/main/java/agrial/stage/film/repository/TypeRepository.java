package agrial.stage.film.repository;

import agrial.stage.film.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {
}