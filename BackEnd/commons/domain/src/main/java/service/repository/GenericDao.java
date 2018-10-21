package service.repository;

public interface GenericDao<T> {


     T saveOrUpdate(T t,Long primaryKey);
}
