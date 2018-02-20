package test.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import test.library.entity.Book;
import test.library.forms.TestForm;
import test.library.model.AddBookAjaxModel;
import test.library.service.BookService;

import java.util.List;

@RestController
public class BookRestService {

    @Autowired
    private BookService bookService;

    @RequestMapping(name = "/getAllBooks", method = RequestMethod.GET)
    public List<Book> testForm(){
        return bookService.getAllBooks();
    }

    @RequestMapping(name = "/addBookRest", method = RequestMethod.POST)
    public ResponseEntity<?> addBookRest(@RequestBody AddBookAjaxModel inputBook){

        if (bookService.isBookExistByAuthorId(inputBook)) {
            return ResponseEntity.status(205).build();
        }

        bookService.addBook(inputBook);
        return ResponseEntity.ok().build();
    }

}

