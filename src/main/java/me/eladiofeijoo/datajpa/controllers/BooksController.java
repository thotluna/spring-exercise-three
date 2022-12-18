package me.eladiofeijoo.datajpa.controllers;

import me.eladiofeijoo.datajpa.entities.Book;
import me.eladiofeijoo.datajpa.exceptions.BookNotFoundException;
import me.eladiofeijoo.datajpa.services.BooksServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    private final BooksServices services;

    public BooksController(BooksServices services) {
        this.services = services;
    }

    @GetMapping("/v1/book")
    public List<Book> findAll(){
        return services.findAll();
    }

    @GetMapping("/v1/book/{id}")
    public Book findById(@PathVariable Long id){
        assert id != null;
        return services.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @PostMapping("/v1/book")
    public Book save(@RequestBody Book book){
        assert book != null;
        return services.save(book);
    }

    @PutMapping("/v1/book/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        if(id != book.getId()) throw  new BookNotFoundException(id);
        Book bookOld = services.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setId(id);
        return services.update(book);
    }

    @DeleteMapping("/v1/book/{id}")
    public void delete(@PathVariable Long id){
        assert id != null;
        services.delete(id);
    }

}
