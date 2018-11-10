package com.gvt.ika.app.service.repository.impl;

import com.gvt.ika.app.entity.bo.master.MasterCategory;
import com.gvt.ika.app.entity.bo.master.SubCategory;
import com.gvt.ika.app.service.repository.GenericRepository;
import com.gvt.ika.app.service.repository.MasterCategoryRepository;
import com.gvt.ika.common.domain.PersistenceType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MasterCategoryRepositoryImpl extends GenericRepositoryImpl<MasterCategory> implements MasterCategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public MasterCategory findMasterCategoryByCode(String code) {
        String jpql = "SELECT mc FROM MasterCategory mc WHERE mc.code=:code";
        TypedQuery<MasterCategory> query = entityManager.createQuery(jpql, MasterCategory.class);
        query.setParameter("code", code);
        List<MasterCategory> resultset = query.getResultList();
        if (!resultset.isEmpty()) {
            return resultset.get(0);
        }
        return null;
    }


    public MasterCategory saveOrUpdateMasterCategory(MasterCategory masterCategory) {

         return saveOrUpdate(PersistenceType.findPersistenceType(masterCategory.getId()),masterCategory);
    }


}
