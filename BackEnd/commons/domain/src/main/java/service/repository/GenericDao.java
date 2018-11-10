package service.repository;

public interface GenericDao<T> {


     public void delete(Long primaryKey);

     T saveOrUpdate(T t,Long primaryKey);
}
