package com.gvt.ika.app.service.business.impl;

import com.gvt.ika.app.entity.bo.master.MasterCategory;
import com.gvt.ika.app.service.business.MasterService;
import com.gvt.ika.app.service.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MasterServiceImpl implements MasterService {


    @Autowired
    private MasterRepository masterRepository;

    @Transactional
    public MasterCategory saveOrUpdate(MasterCategory masterCategory) {
        String code = masterCategory.getCode();
        MasterCategory existing = masterRepository.findByCode(code);
        if (existing != null) {
            existing.setName(masterCategory.getName());
            return masterRepository.saveOrUpdate(existing);
        } else {
            return masterRepository.saveOrUpdate(masterCategory);
        }
    }
}
