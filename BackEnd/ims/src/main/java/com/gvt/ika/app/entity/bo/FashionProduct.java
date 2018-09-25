package com.gvt.ika.app.entity.bo;

import javax.persistence.*;

@Entity
@Table(name="FASHION_PRODUCT")
public class FashionProduct  extends Product {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
}
