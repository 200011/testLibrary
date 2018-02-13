package test.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.library.service.BookService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest/book")
@Component
public class BookRestService {
    @Autowired
    private BookService bookService;

    @GET
    @Path("/add/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(@PathParam("param") String msg){
        System.out.println();

        return null;
    }
}

