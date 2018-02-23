package test.library.soap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import test.library.service.BookService;
import test.library.soap.book.SetBookRequest;
import test.library.soap.book.SetBookResponse;

@Endpoint
public class BookEndpoint {
    private static final String NAMESPACE_URI = "http://library.test/soap/book";

    @Autowired
    private BookService bookService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "setBookRequest")
    @ResponsePayload
    public SetBookResponse addBook(@RequestPayload SetBookRequest request) {
        SetBookResponse response = new SetBookResponse();

        if(bookService.isBookExistByAuthorId(request.getAuthorId(), request.getBook())){
            response.setAnswer("Book exist");
            return response;
        }

        bookService.addBook(request.getAuthorId(), request.getBook());
        response.setAnswer("Book is added");
        return response;
    }
}
