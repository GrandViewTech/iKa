package com.gvt.ika.app.service.repository.impl;

import com.gvt.ika.app.entity.bo.AuthToken;
import com.gvt.ika.app.service.repository.AuthTokenRepository;
import org.springframework.stereotype.Repository;
import service.repository.impl.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class AuthTokenRepositoryImpl extends GenericDaoImpl<AuthToken> implements AuthTokenRepository
{

  public AuthToken findByCompanyIdApplicationIdUserIdAndTokenValue(Long companyId , Long applicationId , Long userId , String token)
    {

            String jpql = "SELECT token FROM AuthToken token";
            jpql += " WHERE token.companyId=:companyId";
            jpql += " AND token.applicationId=:applicationId";
            jpql += " AND token.userId=:userId";
            jpql += " AND token.token=:token";

            EntityManager entityManager = getEntityManager();
            TypedQuery<AuthToken> typedQuery = entityManager.createQuery(jpql, AuthToken.class);
            typedQuery.setParameter("companyId",companyId);
            typedQuery.setParameter("applicationId",applicationId);
            typedQuery.setParameter("userId",userId);
            typedQuery.setParameter("token",token);
            List<AuthToken> resultList=typedQuery.getResultList();
            if(resultList!=null && resultList.size()>0)
            {
                return resultList.get(0);
            }
            return null;

    }

    public AuthToken findActiveTokenByCompanyIdApplicationIdUserId(Long companyId , Long applicationId , Long userId)
    {

        String jpql = "SELECT token FROM AuthToken token";
        jpql += " WHERE token.companyId=:companyId";
        jpql += " AND token.applicationId=:applicationId";
        jpql += " AND token.userId=:userId";
        jpql += " AND token.expireOn > :expireOn";

        EntityManager entityManager = getEntityManager();
        TypedQuery<AuthToken> typedQuery = entityManager.createQuery(jpql, AuthToken.class);
        typedQuery.setParameter("companyId",companyId);
        typedQuery.setParameter("applicationId",applicationId);
        typedQuery.setParameter("userId",userId);
        typedQuery.setParameter("expireOn",System.currentTimeMillis());
        List<AuthToken> resultList=typedQuery.getResultList();
        if(resultList!=null && resultList.size()>0)
        {
            return resultList.get(0);
        }
        return null;

    }

    public void removeInvalidTokens()
    {
        String jpql = "DELETE FROM AuthToken token WHERE token.expireOn < :expireOn";
        EntityManager entityManager = getEntityManager();
        Query typedQuery = entityManager.createQuery(jpql);
        typedQuery.setParameter("expireOn",System.currentTimeMillis());
        typedQuery.executeUpdate();

    }


}
