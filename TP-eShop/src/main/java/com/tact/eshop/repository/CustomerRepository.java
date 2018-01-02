package com.tact.eshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tact.eshop.entity.Customer;

/**
 * Customer data access to database.
 * <i>Use Repository design.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    /**
     * Find all with FirstName filter.
     * @param lastName to search.
     * @return List of Customer.
     */
    List<Customer> findByLastName(String lastName);

    /**
     * Find all with LastName filter.
     * @param firstName to search.
     * @return List of Customer.
     */
    List<Customer> findByFirstName(String firstName);
}
