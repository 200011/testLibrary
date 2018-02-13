package test.library.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.library.entity.Book;
import test.library.model.AjaxResponseBody;
import test.library.model.SearchAjaxModel;
import test.library.service.AuthorService;
import test.library.service.BookService;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    final String index(final Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        return "index";
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    final String search() {
        return "search";
    }

    @ResponseBody
    @RequestMapping(path = "/search", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    final String search(@RequestBody final SearchAjaxModel searchAjaxModel) {
       List<Book> bookList = bookService.searchBooksByCriteria(searchAjaxModel);

       return new Gson().toJson(bookList);
    }
}
