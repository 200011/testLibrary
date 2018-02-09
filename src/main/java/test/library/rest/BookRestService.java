package test.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import test.library.model.AddBookAjaxModel;
import test.library.model.AjaxResponseBody;
import test.library.service.BookService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest/book")
@Component
public class BookRestService {
    @Autowired
    BookService bookService;

    @GET
    @Path("/add/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(@PathParam("param") String msg){
        System.out.println();
        /*AjaxResponseBody responseBody = new AjaxResponseBody();

        if (bookService.isBookExistByAuthorId(addBookAjaxModel)) {
            responseBody.setMsg("Книга уже добавленна");
            responseBody.setCode("205");
            return responseBody;
        }
        bookService.addBook(addBookAjaxModel);
        responseBody.setMsg("Книга добавленна");
        responseBody.setCode("201");
        return responseBody;*/
        return null;
    }
}

