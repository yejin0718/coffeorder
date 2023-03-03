package com.coffeorder.kakaoserver.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeorder.kakaoserver.orders.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
