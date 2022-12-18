package me.eladiofeijoo.datajpa;

import me.eladiofeijoo.datajpa.entities.Book;
import me.eladiofeijoo.datajpa.entities.Car;
import me.eladiofeijoo.datajpa.repositories.BooksRepository;
import me.eladiofeijoo.datajpa.repositories.CarsRepository;
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
		repository.deleteAll();
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

		BooksRepository booksRepository = context.getBean(BooksRepository.class);
		booksRepository.deleteAll();
		System.out.println("Item in Books " + booksRepository.count());

		Book refactoring = new Book(null, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", 432,
				32.39, LocalDate.of(2018,11, 28), true);
		booksRepository.save(refactoring);
		System.out.println("Item in Books " + booksRepository.count());
		for (Book book : booksRepository.findAll()){
			System.out.println(book);
		}
	}

}
