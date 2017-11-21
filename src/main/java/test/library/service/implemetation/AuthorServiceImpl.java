package test.library.service.implemetation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.library.dao.AuthorDao;
import test.library.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDao authorDao;

    public List getAuthorList() {
        return authorDao.getAuthorList();
    }
}
