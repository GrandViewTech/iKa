package com.gvt.ika.app.entity.bo.sku;

import com.gvt.ika.app.entity.bo.Product;

import javax.persistence.*;

@Entity
@Table(name="READING_SKU")
@DiscriminatorValue(value = "READERS")
public class ReadingSKU extends StockKeepingUnit {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLICATION")
    private String publication;
}
