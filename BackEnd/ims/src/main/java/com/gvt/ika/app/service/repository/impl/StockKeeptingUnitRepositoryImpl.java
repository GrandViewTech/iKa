package com.gvt.ika.app.service.repository.impl;

import com.gvt.ika.app.entity.bo.UnitOfMeasurement;
import com.gvt.ika.app.entity.bo.sku.StockKeepingUnit;
import com.gvt.ika.app.service.repository.StockKeeptingUnitRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class StockKeeptingUnitRepositoryImpl implements StockKeeptingUnitRepository
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public StockKeepingUnit findBySkuCode(String code) {

        String jpql = "SELECT sku FROM StockKeepingUnit sku WHERE sku.code=:code";
        TypedQuery<StockKeepingUnit> typedQuery = entityManager.createQuery(jpql, StockKeepingUnit.class);
        typedQuery.setParameter("code", code.trim());
        List<StockKeepingUnit> resultSet = typedQuery.getResultList();
        if (!resultSet.isEmpty()) {
            return resultSet.get(0);
        }
        return null;
    }


    public Set<StockKeepingUnit> saveOrUpdate( Set<StockKeepingUnit> stockKeepingUnits)
    {
        Set<StockKeepingUnit> dbdata=new HashSet<>();
        for(StockKeepingUnit stockKeepingUnit : stockKeepingUnits)

        {
            if(stockKeepingUnit.getId()==null)
            {
                entityManager.persist(stockKeepingUnit);
            }
            else
            {
                stockKeepingUnit=entityManager.merge(stockKeepingUnit);
            }
            dbdata.add(stockKeepingUnit);

        }
        return dbdata;
    }
}
