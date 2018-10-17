package com.gvt.ika.app.entity.bo.sku;

import com.gvt.ika.app.entity.bo.Product;

import javax.persistence.*;

@Entity
@Table(name="HOME_APPLIANCE_SKU")
@DiscriminatorValue(value = "HOME_APPLIANCES")
public class HomeApplianceSKU extends StockKeepingUnit {

    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


}
