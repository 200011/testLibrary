package test.library.service.implemetation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.library.dao.BookDao;
import test.library.entity.Book;
import test.library.model.AddBookAjaxModel;
import test.library.service.AuthorService;
import test.library.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorService authorService;

    public void addBook(AddBookAjaxModel addBookAjaxModel) {
        Book book = new Book();
        book.setBookname(addBookAjaxModel.getBook());
        book.setAuthor(authorService.getAuthorById(addBookAjaxModel.getAuthorId()));
        bookDao.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public List<Book> getBooksByAuthorId(int authorId) {
        return bookDao.getBooksByAuthorId(authorId);
    }

    public boolean isBookExistByAuthorId(AddBookAjaxModel addBookAjaxModel) {
        for (Book book : getBooksByAuthorId(addBookAjaxModel.getAuthorId())) {
            if (book.getBookname().equalsIgnoreCase(addBookAjaxModel.getBook())) {
                return true;
            }
        }
        return false;
    }


}
