package com.gvt.ika.app.service.repository.impl;

import com.gvt.ika.app.entity.bo.Company;
import com.gvt.ika.app.service.repository.CompanyRepository;
import org.apache.commons.lang3.reflect.Typed;
import org.springframework.stereotype.Repository;
import service.repository.GenericDao;
import service.repository.impl.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class CompanyRepositoryImpl extends GenericDaoImpl<Company> implements CompanyRepository , GenericDao<Company>{

    @PersistenceContext
    private EntityManager entityManager;


    public Company findByCompanyId(Long id)
    {
        String jpql="SELECT c FROM Company c WHERE c.id=:id";
        TypedQuery<Company> typedQuery = entityManager.createQuery(jpql,Company.class);
        typedQuery.setParameter("id",id);
        List<Company> resultSet = typedQuery.getResultList();
        if(!resultSet.isEmpty())
        {
            return resultSet.get(0);
        }
        return null;
    }

    public Company saveOrUpdate(Company company)
    {
        return saveOrUpdate(company,company.getId());
    }
}
