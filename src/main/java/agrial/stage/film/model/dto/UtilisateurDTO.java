package agrial.stage.film.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UtilisateurDTO {
    private Integer id;
    private String email;
    private String nom;
    private String prenom;

    @Column(updatable = false)
    private LocalDateTime dateCreation;

    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }
}