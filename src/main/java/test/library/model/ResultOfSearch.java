package test.library.model;

import test.library.entity.Author;
import test.library.entity.Book;

public class ResultOfSearch {
    private Author author;
    private Book book;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
