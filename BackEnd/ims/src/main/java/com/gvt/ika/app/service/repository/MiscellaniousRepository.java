package com.gvt.ika.app.service.repository;

import com.gvt.ika.app.entity.bo.UnitOfMeasurement;

public interface MiscellaniousRepository {

    public UnitOfMeasurement findByUom(String uom);
}
