package com.gvt.ika.app.service.business.impl;

import com.gvt.ika.app.entity.bo.Company;
import com.gvt.ika.app.service.business.CompanyService;
import com.gvt.ika.app.service.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public Company saveOrUpdate(Company company) {

        Company exiting = findByCompanyId(company.getId());
        if (exiting != null) {
            company = exiting.update(company);
        }
        return companyRepository.saveOrUpdate(company);
    }

    public Company findByCompanyId(Long id)
    {
        return companyRepository.findByCompanyId(id);
    }
}
