package com.gvt.ika.app.entity.bo;

import javax.persistence.*;


@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    @Column(name = "COMPANY_NAME", unique = true)
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 public Company update(Company c)
 {
     return this;
 }
}
