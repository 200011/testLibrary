package test.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.library.service.BookService;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(path = "/books/{authorId}", method = RequestMethod.GET)
    String books(@PathVariable(value = "authorId") Integer authorId, Model model){
        model.addAttribute("books",bookService.getBooksByAuthorId(authorId));
        return "books";
    }
}
