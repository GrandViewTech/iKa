package com.gvt.ika.app.service.repository.impl;

import com.gvt.ika.app.entity.bo.Credential;
import com.gvt.ika.app.service.repository.CredentialRepository;
import org.springframework.stereotype.Repository;
import service.repository.GenericDao;
import service.repository.impl.GenericDaoImpl;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CredentialRepositoryImpl extends GenericDaoImpl<Credential> implements CredentialRepository
{

  public  Credential findByUsername(String username)
   {
       String jpql="SELECT crd FROM Credential crd WHERE LOWER(crd.username)=:username";
       TypedQuery<Credential> typedQuery =getEntityManager().createQuery(jpql,Credential.class);
       typedQuery.setParameter("username",username.trim().toLowerCase());
       List<Credential> resultList=   typedQuery.getResultList();
       if(resultList!=null && !resultList.isEmpty())
       {
           return resultList.get(0);
       }
       return null;

   }



}
