package com.gvt.ika.app.service.business.impl;

import com.gvt.ika.app.entity.bo.UnitOfMeasurement;
import com.gvt.ika.app.service.business.MiscellaniousService;
import com.gvt.ika.app.service.business.ProductService;
import com.gvt.ika.app.service.repository.MiscellaniousRepository;
import com.gvt.ika.app.service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiscellaniousServiceImpl implements MiscellaniousService {

    private static Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private MiscellaniousRepository miscellaniousRepository;


    public UnitOfMeasurement findByUom(String uom) {
        return miscellaniousRepository.findByUom(uom);
    }


}
