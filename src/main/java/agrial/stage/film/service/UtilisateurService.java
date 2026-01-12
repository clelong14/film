package agrial.stage.film.service;

import agrial.stage.film.model.Utilisateur;
import agrial.stage.film.model.dto.UtilisateurDTO;
import agrial.stage.film.model.mapper.UtilisateurMapper;
import agrial.stage.film.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
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

    public Optional<UtilisateurDTO> getUtilisateurDTO(Integer id) {
        return utilisateurRepository.findById(id)
                .map(UtilisateurMapper::toDTO);
    }

    public UtilisateurDTO createUtilisateur(Utilisateur utilisateur) {
        if(utilisateurRepository.findByEmail(utilisateur.getEmail()).isPresent()) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }

        String encodedPassword = passwordEncoder.encode(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(encodedPassword);
        // --------------------------------------------------

        Utilisateur saved = utilisateurRepository.save(utilisateur);
        return UtilisateurMapper.toDTO(saved);
    }

    public Optional<UtilisateurDTO> login(String email, String password) {
        return utilisateurRepository.findByEmail(email)
                .filter(u -> passwordEncoder.matches(password, u.getMotDePasse())) // MODIFICATION : matches au lieu de equals
                .map(UtilisateurMapper::toDTO);
    }

    // Lister tous les utilisateurs
    public List<UtilisateurDTO> getAllUtilisateursDTO() {
        return utilisateurRepository.findAll()
                .stream()
                .map(UtilisateurMapper::toDTO)
                .collect(Collectors.toList());
    }

    public boolean utilisateurExists(Integer id) {
    return utilisateurRepository.existsById(id);
    }

    @Transactional
    public void deleteUtilisateur(Integer id) {
        utilisateurRepository.deleteById(id);
    }
}