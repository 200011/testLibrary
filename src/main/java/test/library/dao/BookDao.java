package test.library.dao;

import org.springframework.stereotype.Repository;
import test.library.entity.Book;
import test.library.model.ResultOfSearch;
import test.library.model.SearchAjaxModel;

import java.util.List;


public interface BookDao {
    void addBook(Book book);

    List<Book> getAllBooks();

    List<Book> getBooksByAuthorId(int authorId);

    List<Book> searchBooksByCriteria(SearchAjaxModel searchAjaxModel);
}
