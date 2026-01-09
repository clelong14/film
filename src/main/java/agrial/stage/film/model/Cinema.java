package agrial.stage.film.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String ville;
    private Integer cpostal;
    private String adresse;
    private Integer telephone;
    private String email;

    @OneToMany(mappedBy = "cinema")
    @JsonIgnoreProperties("cinema")
    @JsonBackReference
    private List<Seance> seances;
}
