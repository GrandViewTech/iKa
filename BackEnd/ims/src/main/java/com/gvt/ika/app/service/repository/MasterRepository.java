package com.gvt.ika.app.service.repository;

import com.gvt.ika.app.entity.bo.master.MasterCategory;

public interface MasterRepository {

    public MasterCategory findByCode(String code);

    public MasterCategory saveOrUpdate(MasterCategory masterCategory);
}
