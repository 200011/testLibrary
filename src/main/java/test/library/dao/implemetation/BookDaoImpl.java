package test.library.dao.implemetation;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.library.dao.BookDao;
import test.library.entity.Book;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Book> getAllBooks() {
        return sessionFactory.getCurrentSession().createQuery("from Book ").list();
    }

    @Transactional
    public List<Book> getBooksByAuthorId(int authorId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Book where author.authorId =:authorId");
        query.setParameter("authorId", authorId);
        return query.getResultList();
    }
}
