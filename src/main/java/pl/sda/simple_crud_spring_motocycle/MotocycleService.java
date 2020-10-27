package pl.sda.simple_crud_spring_motocycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MotocycleService {

    @Autowired
    private MotocycleRepository motocycleRepository;

    public void add(MotocycleDTO motocycleDTO) {
        if (motocycleWithVinExists(motocycleDTO.getVin())){
            throw new MotocycleExistsExeption("Motocykl o takim vinie istnie: "
                    +motocycleDTO.getVin());
        }
        Motocycle motocycle=Motocycle.apply(motocycleDTO);
        motocycleRepository.save(motocycle);
        System.out.println("zapisano Moto!");
    }

    private boolean motocycleWithVinExists(String vin) {
        return motocycleRepository.findByVin(vin).isPresent();
    }

    public List<MotocycleDTO> showCarList() {
        return motocycleRepository.findAll()
                .stream()
                .map(m->m.toDTO())
                .collect(Collectors.toList());
    }

    public MotocycleDTO findMotocycleById(Integer id) {
        Optional<Motocycle> motocycle = motocycleRepository.findById(id);
        return changeMotocycleToMotocycleDTO(motocycle,"nie znaleziono samochodu o danym ID");
    }

    public MotocycleDTO findMotocycleByVin(String vin) {
        Optional<Motocycle> motocycle = motocycleRepository.findByVin(vin);
        return changeMotocycleToMotocycleDTO(motocycle,"nie znaleziono samochodu o danym VIN");
    }

    private MotocycleDTO changeMotocycleToMotocycleDTO(Optional<Motocycle> motocycle, String message) {
        return motocycle.map(m->m.toDTO()).orElseThrow(()->new RuntimeException(message));
    }

    public MotocycleDTO updateMotocycle(MotocycleDTO motocycleDTO) {
        Optional<Motocycle> optionalMotocycle = motocycleRepository.findById(motocycleDTO.getId());
        Motocycle motocycle = optionalMotocycle.orElseThrow(()->new RuntimeException("nie znaleziono samochodu o danym ID"));
        motocycle.update(motocycleDTO);
        return motocycleRepository.save(motocycle).toDTO();
    }
}
