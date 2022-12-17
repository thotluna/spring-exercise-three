package me.eladiofeijoo.datajpa;

import me.eladiofeijoo.datajpa.entities.Car;
import me.eladiofeijoo.datajpa.repositories.CarsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DataJpaApplication.class, args);

		CarsRepository repository = context.getBean(CarsRepository.class);
		Car toyota = new Car(null, "Toyota", "Prius",  2010);
		Car chevrolet = new Car(null, "Chevrolet", "Corsa",  2006);
		Car mitsubishi = new Car(null, "Mitsubishi", "L-300",  2007);
		repository.save(toyota);
		repository.save(chevrolet);
		repository.save(mitsubishi);
		List<Car> cars = repository.findAll();
		for (Car car : cars){
			System.out.println(car);
		}
	}

}
