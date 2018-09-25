package com.gvt.ika.app.entity.bo;

import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PROUCT_TYPE" , discriminatorType = DiscriminatorType.STRING )
public abstract class Product {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Embedded
    BasicProductInfo basicProductInfo;
}
