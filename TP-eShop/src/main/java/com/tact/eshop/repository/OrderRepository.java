package com.tact.eshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.tact.eshop.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
