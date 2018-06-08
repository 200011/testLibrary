package test.library.controllers;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.postgresql.core.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.library.model.AddBookAjaxModel;
import test.library.model.AjaxResponseBody;
import test.library.service.AuthorService;
import test.library.service.BookService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class BookController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books/{authorId}.html", method = RequestMethod.GET)
    final String books(@PathVariable(value = "authorId") final Integer authorId, final Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        model.addAttribute("author", authorService.getAuthorById(authorId));
        model.addAttribute("books", bookService.getBooksByAuthorId(authorId));
        return "books";
    }

    @RequestMapping(path = "/addBook.html", method = RequestMethod.GET)
    String addBook(Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        return "addBook";
    }

    @ResponseBody
    @RequestMapping(path = "/addBook.html", method = RequestMethod.POST)
    String addBook(@RequestBody AddBookAjaxModel addBookAjaxModel, HttpServletResponse response) throws IOException {
        AjaxResponseBody responseBody = new AjaxResponseBody();

        if (bookService.isBookExistByAuthorId(addBookAjaxModel)) {
            responseBody.setMsg("Книга уже добавленна");
            responseBody.setCode("205");
            return new Gson().toJson(responseBody);
        }
        bookService.addBook(addBookAjaxModel);
        responseBody.setMsg("Книга добавленна");
        responseBody.setCode("201");
        return new Gson().toJson(responseBody);
    }

    @RequestMapping(path = "/addBookRest.html", method = RequestMethod.GET)
    String addBookRest(final Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        return "REST/addBookRest";
    }
}
