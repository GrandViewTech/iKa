package com.gvt.ika.app.service.repository;


import com.gvt.ika.app.entity.bo.Credential;
import service.repository.GenericDao;

public interface CredentialRepository extends GenericDao<Credential>
{
    public  Credential findByUsername(String username);
}
