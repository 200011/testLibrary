package test.library.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import test.library.entity.Book;
import test.library.forms.TestForm;
import test.library.model.AddBookAjaxModel;
import test.library.service.BookService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;
@RestController
public class BookRestService {

    @Autowired
    private BookService bookService;

    @RequestMapping(name = "/rest/getAllBooks.html", method = RequestMethod.GET)
    public String getAllBooksRest(){
        return new Gson().toJson(bookService.getAllBooks());
    }

    @RequestMapping(name = "/rest/addBook.html", method = RequestMethod.POST)
    public String addBookRest(@RequestBody AddBookAjaxModel inputBook){

        if (bookService.isBookExistByAuthorId(inputBook)) {
            return new Gson().toJson(ResponseEntity.status(205).build());
        }

        bookService.addBook(inputBook);
        return new Gson().toJson(ResponseEntity.ok().build());
    }

}

