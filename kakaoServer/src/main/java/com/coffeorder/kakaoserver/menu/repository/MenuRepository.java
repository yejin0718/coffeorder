package com.coffeorder.kakaoserver.menu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeorder.kakaoserver.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
	Optional<Menu> findByName(String name);
}
