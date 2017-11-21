package test.library.service;

import test.library.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    List<Book> getBooksByAuthorId(int authorId);
}
