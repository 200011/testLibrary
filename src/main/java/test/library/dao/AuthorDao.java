package test.library.dao;

import test.library.entity.Author;

import java.util.List;


public interface AuthorDao {

    Author getAuthorById(int authorId);

    List getAuthorList();
}
