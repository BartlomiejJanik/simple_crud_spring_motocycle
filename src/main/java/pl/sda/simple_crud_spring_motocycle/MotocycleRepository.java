package pl.sda.simple_crud_spring_motocycle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotocycleRepository extends JpaRepository<Motocycle, Integer> {
    @Query("SELECT m from Motocycle m where lower(m.vin) = lower(?1)")
    Optional<Motocycle> findByVin(String vin);
}
