package test.library.dao.implemetation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.library.dao.AuthorDao;
import test.library.entity.Author;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Author> getAuthorList() {
        return sessionFactory.getCurrentSession().createQuery("from Author ").list();
    }
}
