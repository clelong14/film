package agrial.stage.film.service;

import agrial.stage.film.model.Utilisateur;
import agrial.stage.film.model.dto.UtilisateurDTO;
import agrial.stage.film.model.mapper.UtilisateurMapper;
import agrial.stage.film.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Récupérer un utilisateur par son ID (pour la page profil)
    public Optional<UtilisateurDTO> getUtilisateurDTO(Integer id) {
        return utilisateurRepository.findById(id)
                .map(UtilisateurMapper::toDTO);
    }

    // Créer un nouvel utilisateur (Inscription)
    public UtilisateurDTO createUtilisateur(Utilisateur utilisateur) {
        // Optionnel : vérifier si l'email existe déjà
        if(utilisateurRepository.findByEmail(utilisateur.getEmail()).isPresent()) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }
        Utilisateur saved = utilisateurRepository.save(utilisateur);
        return UtilisateurMapper.toDTO(saved);
    }

    // Logique de login
    public Optional<UtilisateurDTO> login(String email, String password) {
        return utilisateurRepository.findByEmail(email)
                .filter(u -> u.getMotDePasse().equals(password)) // À remplacer par BCrypt plus tard
                .map(UtilisateurMapper::toDTO);
    }

    // Lister tous les utilisateurs (Admin)
    public List<UtilisateurDTO> getAllUtilisateursDTO() {
        return utilisateurRepository.findAll()
                .stream()
                .map(UtilisateurMapper::toDTO)
                .collect(Collectors.toList());
    }
}