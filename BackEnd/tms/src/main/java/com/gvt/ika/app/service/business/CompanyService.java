package com.gvt.ika.app.service.business;

import com.gvt.ika.app.entity.bo.Company;

public interface CompanyService {

    public Company saveOrUpdate(Company company);

    public Company findByCompanyId(Long id);
}
