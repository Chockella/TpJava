package com.tact.eshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.tact.eshop.entity.Product;

/**
 * Product data access to database.
 * <i>Use Repository design.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

}
