package service.repository;

import javax.persistence.TypedQuery;

public interface GenericDao<T> {


     public void delete(Long primaryKey);

     T saveOrUpdate(T t,Long primaryKey);

     public TypedQuery<T> getTypedQuery(String jpql);
}
