package service.repository.impl;

import service.repository.GenericDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> classz;


    @PostConstruct
    public void init()
    {
        try {
            Type superclass = this.getClass().getGenericSuperclass();
            Type type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
            classz = Class.forName(type.getTypeName());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void delete(Long primaryKey)
    {
       Object object=  entityManager.find(classz ,primaryKey);
       entityManager.remove(object);
    }

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
