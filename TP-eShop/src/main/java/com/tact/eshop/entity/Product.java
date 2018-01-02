package com.tact.eshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/** Class for Product POJO of eShop project. */
@Entity
@Table(name="shop_product")
public class Product extends EntityBase {

    /** Name of Product. */
    @Column(nullable=false, unique=true, length=25)
    private String name;

    /** Description of Product. */
    @Column(length=255)
    private String description;

    /** Quantity of Product in stock. */
    @Column
    private Integer quantity = 0;

    /** End Of Life of Product. */
    @Column(name="eol")
    private Boolean endOfLife = false;

    /** Unit Price of Product. */
    @Column(precision=2)
    private Float price = 1000.0F;

    /** Hidden default constructor. */
    protected Product() {}

    /**
     * Constructor of Product.
     * @param name of Product.
     */
    public Product(String name) {
        this.setName(name);
        }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the endOfLife
     */
    public Boolean getEndOfLife() {
        return endOfLife;
    }

    /**
     * @param endOfLife the endOfLife to set
     */
    public void setEndOfLife(Boolean endOfLife) {
        this.endOfLife = endOfLife;
    }

    /**
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }

}
