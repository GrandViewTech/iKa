package com.gvt.ika.app.entity.bo.sku;

import javax.persistence.*;

@Entity
@Table(name="TEXTILE_SKU")
@DiscriminatorValue(value = "TEXTILE")
public class TexttileSKU extends StockKeepingUnit {


    @Column(name="COLOUR")
    private String colour;

    @Column(name="FABRIC")
    private String fabric;



    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }
}
