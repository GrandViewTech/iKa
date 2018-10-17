package com.gvt.ika.app.service.repository;

import com.gvt.ika.app.entity.bo.sku.StockKeepingUnit;

import java.util.List;
import java.util.Set;

public interface StockKeeptingUnitRepository {

 StockKeepingUnit findBySkuCode(String code);

    public Set<StockKeepingUnit> saveOrUpdate( Set<StockKeepingUnit> stockKeepingUnits);
}
