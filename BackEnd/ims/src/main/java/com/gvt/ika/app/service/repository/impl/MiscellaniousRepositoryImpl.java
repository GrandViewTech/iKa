package com.gvt.ika.app.service.repository.impl;

import com.gvt.ika.app.entity.bo.Product;
import com.gvt.ika.app.entity.bo.UnitOfMeasurement;
import com.gvt.ika.app.service.repository.MiscellaniousRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MiscellaniousRepositoryImpl implements MiscellaniousRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UnitOfMeasurement findByUom(String uom)
    {
        String jpql = "SELECT u FROM UnitOfMeasurement u WHERE LOWER(uom.uom)=:uom";
        TypedQuery<UnitOfMeasurement> typedQuery = entityManager.createQuery(jpql, UnitOfMeasurement.class);
        typedQuery.setParameter("uom", uom.toLowerCase());
        List<UnitOfMeasurement> resultSet = typedQuery.getResultList();
        if (!resultSet.isEmpty()) {
            return resultSet.get(0);
        }
        return null;

    }
}
