package test.library.service;

import test.library.entity.Book;
import test.library.model.AddBookAjaxModel;
import test.library.model.ResultOfSearch;
import test.library.model.SearchAjaxModel;

import java.util.List;

public interface BookService {
    void addBook(AddBookAjaxModel addBookAjaxModel);

    List<Book> getAllBooks();

    List<Book> getBooksByAuthorId(int authorId);

    boolean isBookExistByAuthorId(AddBookAjaxModel addBookAjaxModel);

    List<Book> searchBooksByCriteria(SearchAjaxModel searchAjaxModel);
}
