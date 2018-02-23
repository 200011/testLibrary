package test.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.library.model.AddBookAjaxModel;
import test.library.model.AjaxResponseBody;
import test.library.service.AuthorService;
import test.library.service.BookService;

@Controller
public class BookController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/books/{authorId}.html", method = RequestMethod.GET)
    final String books(@PathVariable(value = "authorId") final Integer authorId, final Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        model.addAttribute("author", authorService.getAuthorById(authorId));
        model.addAttribute("books", bookService.getBooksByAuthorId(authorId));
        return "books";
    }

    @RequestMapping(path = "/addBook.html", method = RequestMethod.GET)
    final String addBook(final Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        return "addBook";
    }

    @ResponseBody
    @RequestMapping(path = "/addBook.html", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    AjaxResponseBody addBook(@RequestBody AddBookAjaxModel addBookAjaxModel) {
        AjaxResponseBody responseBody = new AjaxResponseBody();

        if (bookService.isBookExistByAuthorId(addBookAjaxModel)) {
            responseBody.setMsg("Книга уже добавленна");
            responseBody.setCode("205");
            return responseBody;
        }
        bookService.addBook(addBookAjaxModel);
        responseBody.setMsg("Книга добавленна");
        responseBody.setCode("201");
        return responseBody;
    }

    @RequestMapping(path = "/addBookRest.html", method = RequestMethod.GET)
    String addBookRest(final Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        return "REST/addBookRest";
    }
}
