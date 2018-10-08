package com.gvt.ika.app.entity.bo;

import javax.persistence.*;

@MappedSuperclass
public abstract class Base {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
