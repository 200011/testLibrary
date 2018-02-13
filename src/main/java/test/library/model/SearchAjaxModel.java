package test.library.model;

import com.fasterxml.jackson.annotation.JsonView;

public class SearchAjaxModel {
    @JsonView
    private String authorName;
    @JsonView
    private String authorSurname;
    @JsonView
    private String book;

    public final String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }

    public final String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(final String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public final String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
