package test.library.model;

import com.fasterxml.jackson.annotation.JsonView;

public class AddBookAjaxModel {

    @JsonView
    private Integer authorId;
    @JsonView
    private String book;

    public final Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(final Integer authorId) {
        this.authorId = authorId;
    }

    public final String getBook() {
        return book;
    }

    public void setBook(final String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "AddBookAjaxModel [authorId=" + authorId + ", book=" + book + "]";
    }
}
