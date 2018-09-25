package com.gvt.ika.app.entity.bo;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Product {


    @Embedded
    BasicProductInfo basicProductInfo;
}
