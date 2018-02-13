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

    @RequestMapping(path = "/books/{authorId}", method = RequestMethod.GET)
    final String books(@PathVariable(value = "authorId") final Integer authorId, final Model model) {
        model.addAttribute("author", authorService.getAuthorById(authorId));
        model.addAttribute("books", bookService.getBooksByAuthorId(authorId));
        return "books";
    }

    @RequestMapping(path = "/addBook", method = RequestMethod.GET)
    final String addBook(final Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        return "addBook";
    }

    @ResponseBody
    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    final AjaxResponseBody addBook(@RequestBody final AddBookAjaxModel addBookAjaxModel) {
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
}
