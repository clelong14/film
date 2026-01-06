package agrial.stage.film.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "producteur")
public class Producteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private String dateNaissance;

    @ManyToOne
    @JoinColumn(name = "directeur_id")

    private Directeur directeur;
}
