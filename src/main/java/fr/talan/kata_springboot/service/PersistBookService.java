package fr.talan.kata_springboot.service;

import fr.talan.kata_springboot.controller.dto.BookDto;
import fr.talan.kata_springboot.model.Book;
import fr.talan.kata_springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@ConditionalOnProperty(name = "book.storage", havingValue = "bdd")
public class PersistBookService implements BookService {
    private final BookRepository repository;

    public PersistBookService(@Autowired BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Book> get(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Book create(BookDto dto) {
        Book b = new Book();
        b.setTitle(dto.title());
        return repository.save(b);
    }

    @Override
    public Collection<Book> findAll() {
        return repository.findAll();
    }
}
