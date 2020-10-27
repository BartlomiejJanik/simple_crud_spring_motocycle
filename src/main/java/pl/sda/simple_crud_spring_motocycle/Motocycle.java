package pl.sda.simple_crud_spring_motocycle;

import javax.persistence.*;

@Entity
public class Motocycle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String model;
    private String vin;
    @Enumerated(EnumType.STRING)
    private Color color;


    public Motocycle() {
    }

    public Motocycle(String model, String vin, Color color) {
        this.model = model;
        this.vin = vin;
        this.color = color;
    }

    public static Motocycle apply(MotocycleDTO motocycleDTO) {
        Motocycle motocycle = new Motocycle();
        motocycle.color = Color.valueOf(motocycleDTO.getColor());
        motocycle.model = motocycleDTO.getModel();
        motocycle.vin = motocycleDTO.getVin();
        motocycle.id = motocycleDTO.getId();
        return motocycle;
    }

    public MotocycleDTO toDTO() {
        return new MotocycleDTO(id, model, vin, color.name());
    }


    public void update(MotocycleDTO motocycleDTO) {
        this.vin= motocycleDTO.getVin();
        this.model=motocycleDTO.getModel();
        this.color=Color.valueOf(motocycleDTO.getColor());
    }
}
