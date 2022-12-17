package me.eladiofeijoo.datajpa.repositories;

import me.eladiofeijoo.datajpa.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {


}
