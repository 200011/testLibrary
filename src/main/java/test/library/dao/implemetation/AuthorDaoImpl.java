package test.library.dao.implemetation;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.library.dao.AuthorDao;
import test.library.entity.Author;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Author getAuthorById(final int authorId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Author where authorId=:authorId");
        query.setParameter("authorId", authorId);
        return (Author) query.uniqueResult();
    }

    @Transactional
    public List<Author> getAuthorList() {
        return sessionFactory.getCurrentSession().createQuery("from Author ").list();
    }
}
