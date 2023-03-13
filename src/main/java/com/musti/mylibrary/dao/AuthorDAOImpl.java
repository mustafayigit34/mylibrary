package com.musti.mylibrary.dao;

import com.musti.mylibrary.entity.Author;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    private EntityManager entityManager;
    @Autowired
    public AuthorDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Author> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Author> theQuery = currentSession.createQuery("from Author", Author.class);

        List<Author> authors = theQuery.getResultList();

        return authors;
    }

    @Override
    public Author findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Author theAuthor = currentSession.get(Author.class, theId);

        return theAuthor;
    }

    @Override
    public Author save(Author theAuthor) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theAuthor);

        return theAuthor;
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Author where id=:authorId");

        theQuery.setParameter("authorId",theId);

        theQuery.executeUpdate();
    }
}
