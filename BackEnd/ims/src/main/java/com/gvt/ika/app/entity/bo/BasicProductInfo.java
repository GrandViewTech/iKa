package com.gvt.ika.app.entity.bo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class BasicProductInfo {

    @Column(name="DESCRIPTION")
    private String description;
}
