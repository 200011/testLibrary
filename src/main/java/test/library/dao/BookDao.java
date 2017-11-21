package test.library.dao;

import org.springframework.stereotype.Repository;
import test.library.entity.Book;

import java.util.List;


public interface BookDao {

    List<Book> getAllBooks();

    List<Book> getBooksByAuthorId(int authorId);
}
