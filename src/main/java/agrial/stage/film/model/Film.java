package agrial.stage.film.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import agrial.stage.film.model.Directeur;
import agrial.stage.film.model.Type;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

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

    private String imagePath;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "directeur_id")
    @JsonManagedReference("film-directeur")
    private Directeur directeur;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @JsonManagedReference("film-type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "producteur_id")
    @JsonManagedReference("film-producteur")
    private Producteur producteur;

    @OneToMany(mappedBy = "film")
    private List<Seance> seances;
}
