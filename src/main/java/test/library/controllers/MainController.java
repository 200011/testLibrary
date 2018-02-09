package test.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.library.model.AjaxResponseBody;
import test.library.model.SearchAjaxModel;
import test.library.service.AuthorService;
import test.library.service.BookService;

@Controller
public class MainController {
    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    String index(Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        return "index";
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    String search() {
        return "search";
    }

    @ResponseBody
    @RequestMapping(path = "/search", method = RequestMethod.POST)
    AjaxResponseBody search(@RequestBody SearchAjaxModel searchAjaxModel) {
        AjaxResponseBody responseBody = new AjaxResponseBody();

        bookService.searchBooksByCriteria(searchAjaxModel);


        return responseBody;
    }
}
