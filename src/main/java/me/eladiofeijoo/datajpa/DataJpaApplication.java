package me.eladiofeijoo.datajpa;

import me.eladiofeijoo.datajpa.entities.Book;
import me.eladiofeijoo.datajpa.entities.Car;
import me.eladiofeijoo.datajpa.repositories.CarsRepository;
import me.eladiofeijoo.datajpa.services.BooksServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DataJpaApplication.class, args);

		CarsRepository repository = context.getBean(CarsRepository.class);
//		repository.deleteAll();
		Car toyota = new Car(null, "Toyota", "Prius",  2010);
		Car chevrolet = new Car(null, "Chevrolet", "Corsa",  2006);
		Car mitsubishi = new Car(null, "Mitsubishi", "L-300",  2007);
		repository.save(toyota);
		repository.save(chevrolet);
		repository.save(mitsubishi);
//		List<Car> cars = repository.findAll();
//		for (Car car : cars){
//			System.out.println(car);
//		}

		BooksServices services = context.getBean(BooksServices.class);
		Book refactoring = new Book(null, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", 432,
				32.39, LocalDate.of(2018,11, 28), true);
		Book uml = new Book(null, "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Martin " +
				"Fowler", 191,32.39, LocalDate.of(2018,8, 30), true);
//		services.deleteAll();
		services.save(refactoring);
		services.save(uml);
//		for (Book book : services.findAll()){
//			System.out.println(book);
//		}

	}

}
