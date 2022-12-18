package me.eladiofeijoo.datajpa.services;

import me.eladiofeijoo.datajpa.entities.Book;
import me.eladiofeijoo.datajpa.repositories.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServices {
    private final BooksRepository repository;

    BooksServices(BooksRepository repository){
        this.repository = repository;
    }

    public List<Book> findAll(){
        return repository.findAll();
    }

    public void save(Book book){
        repository.save(book);
    }

    public void deleteAll(){
        repository.deleteAll();
    }
}
