package pl.sda.simple_crud_spring_motocycle;


public class MotocycleExistsExeption extends RuntimeException {
    public MotocycleExistsExeption(String message) {
        super(message);
    }
}
