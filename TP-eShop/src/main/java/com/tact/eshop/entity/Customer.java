package com.tact.eshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Class for Customer. */
@Entity
@Table(name="shop_customer")
public class Customer extends EntityBase {

    /** First name of Customer. */
    @Column(nullable=false, length=255)
    private String firstName;

    /** Last name of Customer. */
    @Column(nullable=false, length=255)
    private String lastName;

    /** Phone number of Customer. */
    @Column(length=15)
    private String phone;

    /** Address of Customer. */
    @Column(length=255)
    private String address;

    /** Zip code of Customer address. */
    @Column
    private Integer zip;

    /** City of Customer address. */
    @Column(length=25)
    private String city;

    /** List Order of Customer. */
    @OneToMany(mappedBy="customer", cascade=CascadeType.PERSIST)
    private List<Order> orders;

    /** Hidden default constructor. */
    protected Customer() {}

    /**
     * Constructor of Customer.
     * @param firstName of customer.
     * @param lastName of customer.
     */
    public Customer(String firstName, String lastName) {
        this.setFirstName(firstName)
        	.setLastName(lastName);

        this.orders = new ArrayList<Order>();
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName , this.lastName);
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     * @return this instance.
     */
    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @param lastName the lastName to set
     * @return this instance.
     */
    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * @param phone the phone to set
     * @return this instance.
     */
    public Customer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @param address the address to set
     * @return this instance.
     */
    public Customer setAddress(String address) {
        this.address = address;

        return this;
    }

    /**
     * @return the zip
     */
    public Integer getZip() {
        return this.zip;
    }

    /**
     * @param zip the zip to set
     * @return this instance.
     */
    public Customer setZip(Integer zip) {
        this.zip = zip;
        return this;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @param city the city to set
     * @return this instance.
     */
    public Customer setCity(String city) {
        this.city = city;

        return this;
    }

    /**
     * @return the orders
     */
    public List<Order> getOrders() {
        return this.orders;
    }

    /**
     * @param orders the orders to set
     * @return this instance.
     */
    public Customer setOrders(List<Order> orders) {
        this.orders = orders;

        // Bidirectional check
        for (Order order : orders) {
            if (order.getCustomer() != this) {
                order.setCustomer(this);
            }
        }

        return this;
    }

    /**
     * @param order the order to add
     * @return this instance.
     */
    public Customer addOrder(Order order) {
        this.orders.add(order);

        // Bidirectional check
        if (order.getCustomer() != this) {
            order.setCustomer(this);
        }

        return this;
    }

    /**
     *
     * @param order the order to remove
     * @return this instance.
     */
    public Customer removeOrder(Order order) {
        this.orders.remove(order);

        // Bidirectional check
        if (order.getCustomer() == this) {
            order.setCustomer(null);
        }

        return this;
    }

}
