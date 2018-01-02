package com.tact.eshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Class for Order. */
@Entity
@Table(name="shop_order")
public class Order extends EntityBase {

    @Column
    private Float total = 0f;
    
    @Column
    private Boolean finished = false;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
    private List<OrderProduct> products;

    public Order() {
        this.products = new ArrayList<OrderProduct>();
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * @param customer the customer to set
     */
    public Order setCustomer(Customer customer) {
        this.customer = customer;

        // Bidirectional check
        if (customer != null && !customer.getOrders().contains(this)) {
            customer.addOrder(this);
        }

        return this;
    }

    /**
     * @return total
     */
    public Float getTotal() {
        return this.total;
    }

    /**
     * @return order is closed or not
     */
    public Boolean getFinished() {
		return this.finished;
	}

    /**
     * @param finished The boolean
     * @return Order
     */
	public Order setFinished(Boolean finished) {
		this.finished = finished;
		
		return this;
	}
	
	public Order setTotal(Float f) {
		this.total = f;
		return this;
	}
	
	public Order addProduct(Product product, int qt) {
		
		OrderProduct item = new OrderProduct(this, product, qt);
        this.products.add(item);
        
        this.total += product.getPrice() * qt;
        product.setQuantity(product.getQuantity() - qt);

        return this;
    }

    public List<OrderProduct> getOrderedProduct() {
        return this.products;
    }

    public void removeProduct(Product product, int qt) {
    	
    	OrderProduct finded = null;
        for (OrderProduct orderProduct : this.products) {
            if (orderProduct.getProduct().getId() == product.getId()) {
                finded = orderProduct;
            }
        }

        
        finded.setQuantity(finded.getQuantity() - qt);
        if (finded.getQuantity() <= 0) {
            this.products.remove(finded);
        }
    
        
        product.setQuantity(product.getQuantity() + qt);
        this.total -= product.getPrice() * qt;
        
        
    }

}
