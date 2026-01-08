package agrial.stage.film.model.mapper;

import agrial.stage.film.model.Utilisateur;
import agrial.stage.film.model.dto.UtilisateurDTO;

public class UtilisateurMapper {
    public static UtilisateurDTO toDTO(Utilisateur u) {
        if (u == null) return null;
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setId(u.getId());
        dto.setEmail(u.getEmail());
        dto.setNom(u.getNom());
        dto.setPrenom(u.getPrenom());
        dto.setDateCreation(u.getDateCreation());
        return dto;
    }
}