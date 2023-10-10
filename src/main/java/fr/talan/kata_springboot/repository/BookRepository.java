package fr.talan.kata_springboot.repository;

import fr.talan.kata_springboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitle(String title);

    List<Book> findByTitleStartingWith(String title);
}
