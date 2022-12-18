package me.eladiofeijoo.datajpa.services;

import me.eladiofeijoo.datajpa.entities.Book;
import me.eladiofeijoo.datajpa.exceptions.BookNotFoundException;
import me.eladiofeijoo.datajpa.repositories.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServices {
    private final BooksRepository repository;

    BooksServices(BooksRepository repository){
        this.repository = repository;
    }

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Optional<Book> findById(Long id) throws BookNotFoundException {
         return  repository.findById(id);
    }

    public Book save(Book book){
        return repository.save(book);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteAll(){
        try{
            repository.deleteAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
