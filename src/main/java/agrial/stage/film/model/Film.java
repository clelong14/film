package agrial.stage.film.model;

import jakarta.persistence.*;
import lombok.Data;
import agrial.stage.film.model.Directeur;
import agrial.stage.film.model.Type;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_sortie")
    private LocalDate dateSortie;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @Column(name = "duree")
    private String duree;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "directeur_id")
    private Directeur directeur;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
}
