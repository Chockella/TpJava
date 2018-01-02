package com.tact.eshop.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** Class for link Order/Product. */
@Entity
@Table(name="shop_order_product")
public class OrderProduct extends EntityBase {

    protected int quantity = 1;

    @ManyToOne
    protected Product product;

    @ManyToOne
    protected Order order;

    protected OrderProduct() {}

    public OrderProduct(Order order, Product product, int quantity) {
        this.setOrder(order)
        	.setProduct(product)
        	.setQuantity(quantity);
        
        }

    public float getTotal() {
        return this.product.getPrice() * this.quantity;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
