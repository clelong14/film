package agrial.stage.film.controller;

import agrial.stage.film.model.Utilisateur;
import agrial.stage.film.model.dto.UtilisateurDTO;
import agrial.stage.film.repository.UtilisateurRepository;
import agrial.stage.film.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/login")
    public ResponseEntity<UtilisateurDTO> login(@RequestBody Map<String, String> creds) {
        return utilisateurService.login(creds.get("email"), creds.get("password"))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/register")
    public UtilisateurDTO register(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.createUtilisateur(utilisateur);
    }
}