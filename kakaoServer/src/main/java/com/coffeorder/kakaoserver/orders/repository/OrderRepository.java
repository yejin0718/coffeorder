package com.coffeorder.kakaoserver.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeorder.kakaoserver.orders.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
