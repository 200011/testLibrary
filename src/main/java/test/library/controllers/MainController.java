package test.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.library.service.AuthorService;

@Controller
public class MainController {
    @Autowired
    AuthorService authorService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    String index(Model model) {
        model.addAttribute("authors", authorService.getAuthorList());
        return "index";
    }
}
