package test.library.service.implemetation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.library.dao.AuthorDao;
import test.library.entity.Author;
import test.library.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDao authorDao;

    public Author getAuthorById(int authorId) {
        return authorDao.getAuthorById(authorId);
    }

    public List getAuthorList() {
        return authorDao.getAuthorList();
    }
}
