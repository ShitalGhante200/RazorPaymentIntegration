package com.example.RazorDemo.repository;

import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RazorDemo.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findByOrderId(String orderId);

	OrderEntity save(OrderEntity newOrder);
}
