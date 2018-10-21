package com.gvt.ika.app.entity.bo.master;

import javax.persistence.*;

@Entity
@Table(name = "SUB_CATEGORY")
public class SubCategory {


    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "MASTER_CATEGORY_ID")
    private MasterCategory masterCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MasterCategory getMasterCategory() {
        return masterCategory;
    }

    public void setMasterCategory(MasterCategory masterCategory) {
        this.masterCategory = masterCategory;
    }
}
