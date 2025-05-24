package ma.emsi.charity.services;
import ma.emsi.charity.dto.ActionChariteDTO;
import ma.emsi.charity.entities.ActionCharite;
import ma.emsi.charity.entities.Organization;
import ma.emsi.charity.mappers.ActionChariteMapper;
import ma.emsi.charity.repositories.ActionChariteRepository;
import ma.emsi.charity.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionChariteService {

    @Autowired
    private ActionChariteRepository actionRepo;

    @Autowired
    private OrganisationRepository orgRepo;

    public List<ActionChariteDTO> getAllActions() {
        return actionRepo.findAll()
                .stream()
                .map(ActionChariteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ActionChariteDTO createAction(ActionChariteDTO dto) {
        Organization org = orgRepo.findById(dto.getOrganizationId())
                .orElseThrow(() -> new RuntimeException("Organization not found"));

        ActionCharite action = ActionChariteMapper.toEntity(dto, org);
        return ActionChariteMapper.toDTO(actionRepo.save(action));
    }

    public ActionChariteDTO getById(Long id) {
        ActionCharite action = actionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Action not found"));
        return ActionChariteMapper.toDTO(action);
    }

    public void deleteAction(Long id) {
        actionRepo.deleteById(id);
    }

    public ActionChariteDTO updateAction(Long id, ActionChariteDTO dto) {
        ActionCharite action = actionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Action not found"));

        action.setTitre(dto.getTitre());
        action.setDescription(dto.getDescription());
        action.setDate(dto.getDate());
        action.setLieu(dto.getLieu());
        action.setObjectifCollecte(dto.getObjectifCollecte());
        action.setMontantActuel(dto.getMontantActuel());
        action.setMediaUrl(dto.getMediaUrl());
        action.setEstArchivee(dto.isEstArchivee());

        return ActionChariteMapper.toDTO(actionRepo.save(action));
    }
}

