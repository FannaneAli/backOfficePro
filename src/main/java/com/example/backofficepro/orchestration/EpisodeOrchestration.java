package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.EpisodeDTO;
import com.example.backofficepro.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Orchestrateur pour la gestion des épisodes.
 * Coordonne les interactions entre les contrôleurs REST et le service des épisodes.
 * Responsable de :
 * - La transmission des requêtes aux services appropriés
 * - L'adaptation des flux de données pour la couche présentation
 * - La gestion centralisée des opérations CRUD sur les épisodes
 */

@Component
public class EpisodeOrchestration {

    @Autowired
    private IEpisodeService episodeService;

    public EpisodeDTO getEpisodeById(Long id) {
        return episodeService.getEpisodeById(id);
    }

    public List<EpisodeDTO> getAllEpisodes() {
        return episodeService.getAllEpisodes();
    }

    public EpisodeDTO createEpisode(EpisodeDTO episodeDTO) {
        return episodeService.createEpisode(episodeDTO);
    }

    public EpisodeDTO updateEpisode(Long id, EpisodeDTO episodeDTO) {
        return episodeService.updateEpisode(id, episodeDTO);
    }

    public void deleteEpisode(Long id) {
        episodeService.deleteEpisode(id);
    }
}
