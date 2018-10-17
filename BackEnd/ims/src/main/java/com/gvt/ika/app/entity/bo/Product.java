package com.gvt.ika.app.entity.bo;

import com.gvt.ika.app.entity.bo.sku.StockKeepingUnit;
import com.gvt.ika.common.domain.entity.converter.Boolean2StringConverter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;


    @Column(name = "BRAND", nullable = false)
    private String brand;


    @Column(name = "CODE", nullable = false,unique = true)
    private String code;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = UnitOfMeasurement.class)
    @JoinColumn(name = "UOM")
    private UnitOfMeasurement unitOfMeasurement;

    @Convert(converter = Boolean2StringConverter.class)
    @Column(name = "DISPLAY", nullable = false)
    private boolean display =true;

    @OneToMany(mappedBy = "product")
    private Set<StockKeepingUnit> stockKeepingUnits = new HashSet<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public Set<StockKeepingUnit> getStockKeepingUnits() {
        return stockKeepingUnits;
    }

    public void setStockKeepingUnits(Set<StockKeepingUnit> stockKeepingUnits) {
        this.stockKeepingUnits = stockKeepingUnits;
    }
}
