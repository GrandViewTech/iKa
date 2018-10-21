package com.gvt.ika.app.service.repository.impl;

import com.gvt.ika.app.entity.bo.master.MasterCategory;
import com.gvt.ika.app.entity.bo.master.SubCategory;
import com.gvt.ika.app.service.repository.MasterRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MasterRepositoryImpl implements MasterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public MasterCategory findByCode(String code) {
        String jpql = "SELECT mc FROM MasterCategory mc WHERE mc.code=:code";
        TypedQuery<MasterCategory> query = entityManager.createQuery(jpql, MasterCategory.class);
        query.setParameter("code", code);
        List<MasterCategory> resultset = query.getResultList();
        if (!resultset.isEmpty()) {
            return resultset.get(0);
        }
        return null;
    }


    public MasterCategory saveOrUpdate(MasterCategory masterCategory) {

        if (masterCategory.getId() == null) {
            entityManager.persist(masterCategory);
            return masterCategory;
        } else {
            masterCategory = entityManager.merge(masterCategory);
            return masterCategory;
        }
    }


    public SubCategory saveOrUpdate(SubCategory subCategory) {

        if (subCategory.getId() == null) {
            entityManager.persist(subCategory);
            return subCategory;
        } else {
            subCategory = entityManager.merge(subCategory);
            return subCategory;
        }
    }
}
