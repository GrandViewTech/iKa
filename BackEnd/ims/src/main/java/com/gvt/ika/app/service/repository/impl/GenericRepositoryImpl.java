package com.gvt.ika.app.service.repository.impl;

import com.gvt.ika.app.service.repository.GenericRepository;
import com.gvt.ika.common.domain.PersistenceType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericRepositoryImpl<T> implements GenericRepository<T>
{

    @PersistenceContext
    private EntityManager entityManager;

    public T saveOrUpdate(PersistenceType persistenceType , T t)
    {
        switch (persistenceType)
        {
            case MERGE: return entityManager.merge(t);
            case PERSIST: { entityManager.persist(t); return t;}
            default:{entityManager.persist(t); return t;}
        }
    }
}
