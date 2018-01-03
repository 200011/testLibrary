package test.library.service;

import test.library.entity.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthorById(int authorId);

    List getAuthorList();
}
