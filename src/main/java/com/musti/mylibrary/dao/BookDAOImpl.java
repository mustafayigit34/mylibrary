package com.musti.mylibrary.dao;

import com.musti.mylibrary.entity.Book;
import com.musti.mylibrary.model.BookResponseDTO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{

    private EntityManager entityManager;
    @Autowired
    public BookDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<BookResponseDTO> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Book> theQuery = currentSession.createQuery("from Book", Book.class);

        List<Book> books = theQuery.getResultList();

        List<BookResponseDTO> bookResponseDTO = new ArrayList<BookResponseDTO>();

        for (Book book: books) {
            bookResponseDTO.add(new BookResponseDTO(book));
        }

        return bookResponseDTO;
    }

    @Override
    public Book findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Book theBook = currentSession.get(Book.class, theId);

        return theBook;
    }

    @Override
    public void save(Book theBook) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theBook);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Book where id=:bookId");

        theQuery.setParameter("bookId",theId);

        theQuery.executeUpdate();
    }
}
