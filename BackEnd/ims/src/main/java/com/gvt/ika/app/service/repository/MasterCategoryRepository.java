package com.gvt.ika.app.service.repository;

import com.gvt.ika.app.entity.bo.master.MasterCategory;
import com.gvt.ika.app.entity.bo.master.SubCategory;

public interface MasterCategoryRepository  extends GenericRepository<MasterCategory>{

    public MasterCategory findMasterCategoryByCode(String code);

    public MasterCategory saveOrUpdateMasterCategory(MasterCategory masterCategory);


}
