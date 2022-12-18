package me.eladiofeijoo.datajpa.repositories;

import me.eladiofeijoo.datajpa.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {
}
