package agrial.stage.film.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "libelle")
    private String libelle;
}
