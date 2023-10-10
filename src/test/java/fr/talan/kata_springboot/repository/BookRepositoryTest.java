package fr.talan.kata_springboot.repository;

import fr.talan.kata_springboot.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @BeforeEach
    void setup(){
        repository.deleteAll();
    }

    @Test
    void createMustSuccess(){
        Book b = repository.save(new Book("Test insert"));

        Assertions.assertNotNull(b.getId());
    }

    @Test
    void findDocumentByTitleMustReturnBooks(){
        String title = "Title to find";
        repository.save(new Book(title));

        List<Book> books = repository.findByTitle(title);
        Assertions.assertEquals(1, books.size());
    }

    @Test
    void findDocumentByTitleStartingWith(){
        repository.save(new Book("James bond contre docteur no"));
        repository.save(new Book("Goldeneye"));
        repository.save(new Book("Goldfinger"));
        repository.save(new Book("Golden gun"));
        repository.save(new Book("James bond contre attaque"));

        Assertions.assertEquals(3,repository.findByTitleStartingWith("Gold").size());
        Assertions.assertEquals(2,repository.findByTitleStartingWith("Golden").size());
        Assertions.assertEquals(2,repository.findByTitleStartingWith("James").size());
        Assertions.assertEquals(2,repository.findByTitleStartingWith("James bond").size());
        Assertions.assertEquals(0,repository.findByTitleStartingWith("Skyfall").size());
    }
}
