package com.tact.eshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.tact.eshop.entity.OrderProduct;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long>{

}
