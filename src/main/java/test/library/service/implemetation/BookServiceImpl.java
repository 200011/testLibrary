package test.library.service.implemetation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.library.dao.BookDao;
import test.library.entity.Book;
import test.library.model.AddBookAjaxModel;
import test.library.model.SearchAjaxModel;
import test.library.service.AuthorService;
import test.library.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorService authorService;

    public final void addBook(final AddBookAjaxModel addBookAjaxModel) {
        Book book = new Book();
        book.setBookname(addBookAjaxModel.getBook());
        book.setAuthor(authorService.getAuthorById(addBookAjaxModel.getAuthorId()));
        bookDao.addBook(book);
    }

    public final List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public final List<Book> getBooksByAuthorId(final int authorId) {
        return bookDao.getBooksByAuthorId(authorId);
    }

    public final boolean isBookExistByAuthorId(final AddBookAjaxModel addBookAjaxModel) {
        for (Book book : getBooksByAuthorId(addBookAjaxModel.getAuthorId())) {
            if (book.getBookname().equalsIgnoreCase(addBookAjaxModel.getBook())) {
                return true;
            }
        }
        return false;
    }

    public final List<Book> searchBooksByCriteria(final SearchAjaxModel searchAjaxModel) {
        return bookDao.searchBooksByCriteria(searchAjaxModel);
    }


}
