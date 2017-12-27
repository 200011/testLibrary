package test.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.library.model.AjaxResponseBody;
import test.library.model.SearchCriteria;
import test.library.service.AuthorService;
import test.library.service.BookService;

import java.util.Map;

@Controller
public class BookController {
    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @RequestMapping(path = "/books/{authorId}", method = RequestMethod.GET)
    String books(@PathVariable(value = "authorId") Integer authorId, Model model){
        model.addAttribute("books",bookService.getBooksByAuthorId(authorId));
        return "books";
    }

    @RequestMapping(path = "/addBook", method = RequestMethod.GET)
    String addBook(Model model){
        model.addAttribute("authors",authorService.getAuthorList());
        return "addBook";
    }

    @ResponseBody
    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    String addBook(@RequestBody Map<String,String> data ){
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        System.out.println("qweqweqwe");
        return "addBook";
    }
}
