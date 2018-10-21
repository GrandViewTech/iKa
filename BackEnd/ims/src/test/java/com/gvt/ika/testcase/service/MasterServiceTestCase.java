package com.gvt.ika.testcase.service;

import com.gvt.ika.app.entity.bo.master.MasterCategory;
import com.gvt.ika.app.service.business.MasterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MasterServiceTestCase extends TestCase {

    @Autowired
    private MasterService masterService;

    @Test
public void addMasterCategory()
{
    MasterCategory masterCategory = new MasterCategory();
    masterCategory.setName("Vehicles & Parts");
    masterCategory.setCode("VP1");
    masterService.saveOrUpdate(masterCategory);
}
}
