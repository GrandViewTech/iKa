package com.gvt.ika.app.entity.bo.sku;

import javax.persistence.*;

@Entity
@Table(name="HEALTH_AND_BEAUTY_SKU")
@DiscriminatorValue(value = "HEALTH_AND_BEAUTY")
public class HealthAndBeautySKU extends StockKeepingUnit {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

}

