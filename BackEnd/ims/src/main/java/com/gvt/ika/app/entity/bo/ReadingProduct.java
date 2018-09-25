package com.gvt.ika.app.entity.bo;

import javax.persistence.*;

@Entity
@Table(name="READING_PRODUCT")
@DiscriminatorValue(value = "READERS")
public class ReadingProduct extends Product {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLICATION")
    private String publication;
}
