package service.repository.impl;

import service.repository.GenericDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public T saveOrUpdate(T t, Long primaryKey) {
        if (primaryKey == null) {
            entityManager.persist(t);
            return t;
        } else {
            t = entityManager.merge(t);
            return t;
        }
    }





}
