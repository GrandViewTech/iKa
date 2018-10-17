package com.gvt.ika.app.entity.bo;

import javax.persistence.*;

@Entity
@Table(name="UNIT_OF_MEASUREMENT")
public class UnitOfMeasurement {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "UOM", length = 10,unique = true)
    private String uom;

    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UnitOfMeasurement() {super();
    }

    public UnitOfMeasurement(String uom) {
        this.uom = uom;
    }
}
