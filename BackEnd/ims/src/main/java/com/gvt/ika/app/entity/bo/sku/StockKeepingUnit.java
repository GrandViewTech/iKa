package com.gvt.ika.app.entity.bo.sku;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gvt.ika.app.entity.bo.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "STOCK_KEEPING_UNIT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "SKU_TYPE", discriminatorType = DiscriminatorType.STRING)
public class StockKeepingUnit {


    @Id
    @Column(name = "ID", length = 30)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "QUANTITY", nullable = false)
    private BigDecimal quantity;

    @Column(name = "UNIT_PRICE", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "CODE", unique = true)
    private String code;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }




    /**
     * UPDATE METHOD
     */

    public StockKeepingUnit update(StockKeepingUnit stockKeepingUnit)
    {
        return  this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockKeepingUnit that = (StockKeepingUnit) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
