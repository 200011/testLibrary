package test.library.model;

import com.fasterxml.jackson.annotation.JsonView;

public class AddBookAjaxModel {

    @JsonView
    Integer authorId;
    @JsonView
    String book;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "AddBookAjaxModel [authorId=" + authorId + ", book=" + book + "]";
    }
}
