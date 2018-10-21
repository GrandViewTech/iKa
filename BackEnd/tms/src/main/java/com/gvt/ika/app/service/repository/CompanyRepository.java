package com.gvt.ika.app.service.repository;

import com.gvt.ika.app.entity.bo.Company;
import service.repository.GenericDao;

public interface CompanyRepository {
    public Company saveOrUpdate(Company company);

    public Company findByCompanyId(Long id);

}
