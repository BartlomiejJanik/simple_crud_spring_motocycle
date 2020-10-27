package pl.sda.simple_crud_spring_motocycle;


public class MotocycleDTO {

    private Integer id;
    private String model;
    private String vin;
    private String color;

    public MotocycleDTO(Integer id, String model, String vin, String color) {
        this.id = id;
        this.model = model;
        this.vin = vin;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public String getColor() {
        return color;
    }
}
