package com.gvt.ika.app.entity.bo;

import javax.persistence.*;

@Entity
@Table(name="HEALTH_AND_BEAUTY_PRODUCT")
@DiscriminatorValue(value = "HEALTH_AND_BEAUTY")
public class HealthAndBeautyProduct extends Product {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

}

