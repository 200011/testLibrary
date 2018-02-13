package test.library.dao.implemetation;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.library.dao.BookDao;
import test.library.entity.Author;
import test.library.entity.Book;
import test.library.entity.Book_;
import test.library.model.SearchAjaxModel;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;
import test.library.entity.Author_;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addBook(final Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Transactional
    public List<Book> getAllBooks() {
        return sessionFactory.getCurrentSession().createQuery("from Book ").list();
    }

    @Transactional
    public List<Book> getBooksByAuthorId(final int authorId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Book where author.authorId =:authorId");
        query.setParameter("authorId", authorId);
        return query.getResultList();
    }

    @Transactional
    public List<Book> searchBooksByCriteria(final SearchAjaxModel searchAjaxModel) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Book> bookCriteria = cb.createQuery(Book.class);
        Root<Book> bookRoot = bookCriteria.from(Book.class);

        Join<Book, Author> authorJoin = bookRoot.join(Book_.author);
        bookCriteria.where(
                cb.like(bookRoot.<String>get(Book_.bookname), searchAjaxModel.getBook()+"%"),
                cb.and(cb.like(authorJoin.<String>get(Author_.name), searchAjaxModel.getAuthorName()+"%")),
                cb.and(cb.like(authorJoin.<String>get(Author_.surname), searchAjaxModel.getAuthorSurname()+"%"))
        );

        return sessionFactory.getCurrentSession().createQuery(bookCriteria).getResultList();
    }
}
