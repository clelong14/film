package agrial.stage.film.service;

import agrial.stage.film.model.Directeur;
import agrial.stage.film.model.dto.DirecteurDTO;
import agrial.stage.film.model.mapper.DirecteurMapper;
import agrial.stage.film.repository.DirecteurRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class DirecteurService {
    @Autowired
    private DirecteurRepository directeurRepository;

    public DirecteurDTO saveDirecteurDTO(DirecteurDTO dto) {
        Directeur entity = DirecteurMapper.toEntity(dto);
        Directeur saved = directeurRepository.save(entity);
        return DirecteurMapper.toDTO(saved);

    }

    public List<DirecteurDTO> getAllDirecteursDTO() {
        return directeurRepository.findAll()
                .stream()
                .map(DirecteurMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DirecteurDTO> getDirecteurDTO(Integer id) {
        return directeurRepository.findById(id)
                .map(DirecteurMapper::toDTO);
    }

    public Directeur saveDirecteur(Directeur directeur) {
        Directeur savedDirecteur = directeurRepository.save(directeur);
        return savedDirecteur;
    }

    public List<Directeur> findByNom(String nom) {
        return directeurRepository.findByNomSansEspace(nom);
    }

    public List<Directeur> getDirecteursParFilm(Integer id) {
        return directeurRepository.findByFilms_Id(id);
    }
}
