package com.musti.mylibrary.dao;

import com.musti.mylibrary.entity.Type;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TypeDAOImpl implements TypeDAO {

    private EntityManager entityManager;
    @Autowired
    public TypeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Type> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Type> theQuery = currentSession.createQuery("from Type", Type.class);

        List<Type> types = theQuery.getResultList();

        return types;
    }

    @Override
    public Type findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Type theType = currentSession.get(Type.class, theId);

        return theType;
    }

    @Override
    public Type save(Type theType) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theType);

        return theType;
    }

    /*
    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Type where id=:typeId");

        theQuery.setParameter("typeId",theId);

        theQuery.executeUpdate();
    }
    */
}
