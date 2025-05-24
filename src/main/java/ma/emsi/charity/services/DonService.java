package ma.emsi.charity.services;
import ma.emsi.charity.dto.DonDTO;
import ma.emsi.charity.entities.Don;
import ma.emsi.charity.mappers.DonMapper;
import ma.emsi.charity.repositories.DonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonService {

    private final DonRepository donRepository;

    public DonService(DonRepository donRepository) {
        this.donRepository = donRepository;
    }

    public List<Don> getAllDons() {
        return donRepository.findAll();
    }

    public Optional<Don> getDonById(Long id) {
        return donRepository.findById(id);
    }

    public Don createDon(Don don) {
        return donRepository.save(don);
    }

    public Don createDonFromDto(DonDTO dto) {
        Don don = DonMapper.dtoToEntity(dto);
        return donRepository.save(don);
    }

    public void deleteDon(Long id) {
        donRepository.deleteById(id);
    }

    public List<DonDTO> getAllDonDTOs() {
        return donRepository.findAll().stream()
                .map(DonMapper::entityToDto)
                .collect(Collectors.toList());
    }
}