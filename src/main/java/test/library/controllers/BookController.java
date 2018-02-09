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
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @RequestMapping(path = "/books/{authorId}", method = RequestMethod.GET)
    String books(@PathVariable(value = "authorId") Integer authorId, Model model) {
        model.addAttribute("author", authorService.getAuthorById(authorId));
        model.addAttribute("books", bookService.getBooksByAuthorId(authorId));
        return "books";
    }

    @RequestMapping(path = "/addBook", method = RequestMethod.GET)
    String addBook(Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        return "addBook";
    }

    @ResponseBody
    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
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
}
