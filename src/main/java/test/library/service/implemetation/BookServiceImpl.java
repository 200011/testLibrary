package test.library.service.implemetation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.library.dao.BookDao;
import test.library.entity.Book;
import test.library.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public List<Book> getBooksByAuthorId(int authorId) {
        return bookDao.getBooksByAuthorId(authorId);
    }
}
