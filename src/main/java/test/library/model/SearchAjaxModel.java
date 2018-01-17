package test.library.model;

import com.fasterxml.jackson.annotation.JsonView;

public class SearchAjaxModel {
    @JsonView
    String authorName;
    @JsonView
    String authorSurname;
    @JsonView
    String book;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
