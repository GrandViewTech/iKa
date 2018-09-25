package com.gvt.ika.app.entity.bo;

import javax.persistence.*;

@Entity
@Table(name="HOME_PRODUCT")
@DiscriminatorValue(value = "HOME_APPLIANCES")
public class HomeProduct extends Product {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "BRAND")
    private String brand;
}
