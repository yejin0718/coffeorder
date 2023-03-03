package com.coffeorder.kakaoserver.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeorder.kakaoserver.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
