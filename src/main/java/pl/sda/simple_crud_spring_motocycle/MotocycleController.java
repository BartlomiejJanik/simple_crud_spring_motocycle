package pl.sda.simple_crud_spring_motocycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/motocycles")
public class MotocycleController {

    @Autowired
    private MotocycleService motocycleService;

    @PostMapping
    public void add(@RequestBody MotocycleDTO motocycleDTO) {
        motocycleService.add(motocycleDTO);
    }

    @GetMapping
    public List<MotocycleDTO> showMotocycleList() {
        return motocycleService.showCarList();
    }

    @GetMapping("/{id}")
    public MotocycleDTO findMotocycleById(@PathVariable Integer id) {
        return motocycleService.findMotocycleById(id);
    }

    @GetMapping("/vin/{vin}")
    public MotocycleDTO findMotocycleByVin(@PathVariable String vin) {
        return motocycleService.findMotocycleByVin(vin);
    }
    @PutMapping("/{id}")
    public MotocycleDTO updateMotocycle(@PathVariable Integer id ,@RequestBody MotocycleDTO motocycleDTO){
        return motocycleService.updateMotocycle(motocycleDTO);
    }
}
